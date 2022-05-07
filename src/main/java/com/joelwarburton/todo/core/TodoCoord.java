package com.joelwarburton.todo.core;


import com.joelwarburton.todo.dao.TodoDao;

import java.util.ArrayList;

/**
 * TodoCoord is used to store the list of different to-do lists.
 * This includes the loading and saving functionality of the main application.
 */
public class TodoCoord {

    private ArrayList<TodoList> lists;
    private TodoDao database;
    private int idIndex;




    public TodoCoord() {
        lists = new ArrayList<>();
        database = new TodoDao();
        int idIndex = 1;
        loadData();
    }

    private void loadData() {
        ArrayList<String> data = database.loadData();
        if(data.size() == 0) {
            //do nothing
        } else {
            createLists(data.remove(0));
            idIndex = Integer.valueOf(data.remove(0));

            fillLists(data);
        }
    }


    public void saveData() {
        //TODO collect the data for every list and save it into a csv

        //adds the categories to the datafile
        ArrayList<String> data = new ArrayList<>();

        //adds list names as a single line of the csv data file
        data.add(listsAsCSV());
        
        data.add(String.valueOf(idIndex)); //save id index for future tasks.
        
        //adds the tasks to the data
        addTasksToSave(data);

        for(String string : data) {
            System.out.println(string);
        }

    }

    private String listsAsCSV() {
        StringBuilder sb = new StringBuilder();

        lists.forEach(list -> {
            if(sb.length() != 0) {
                sb.append(",");
            }
            sb.append(list.getName());
        });

        return sb.toString();
    }


    private void addTasksToSave(ArrayList<String> data) {

        lists.stream().forEach(list -> {
            StringBuilder sb = new StringBuilder();

            list.getTasks().stream().forEach(task -> {
                sb.append(task.getID() + "," + list.getName() + "," + task.getTitle() + "," + task.getNote()
                        + "," + task.getDateCreated() + "," + task.getDateDue() + "," + task.getRepeatFrequency());
                data.add(sb.toString());

            });
        });


    }


    private void createLists(String row){
        String[] lists = row.split(",");
        for (String listName : lists) {
            this.addList(listName);
        }
    }

    private void fillLists(ArrayList<String> listData) {

        //loop through each row
        for(String row : listData) {
            String[] columns = row.split(",");

            //check column 1 for the list name that it belongs to.
            //send the row to the list for processing
            getList(columns[1]).addTask(columns);
        }
        System.out.println("Todays list:" + getList("ListOne").getTasks());
    }




    public boolean addList(String listName) {



        //add the list if the name is unique
        if(isNameUnique(listName))
        {
            return this.lists.add(new TodoList(listName));

        } else {
            //generate number to add the end of the list
            //if a number is already appended and is in the list then add one and try the add again.
            int number = 0;
            boolean isUnique = false;
            String newName = "";
            while (!isUnique) {
                number++;
                newName = listName + " (" + number + ")";
                isUnique = isNameUnique(newName);
            }

            return this.lists.add(new TodoList(newName));
        }

    }


    /*Helper function to check if the name argument is unique to the list*/
    private boolean isNameUnique(String name) {

        if(lists.size() == 0) {
            return true;
        }

        for(TodoList list : lists) {

            if(list.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }


/*
    public TodoList removeList(String listName) {

        //TODO remove a list from the collection using its name
    }
*/
    public TodoList getList(String listName) {

        TodoList theList = null;
        for(TodoList list : lists) {
            if(list.getName().equals(listName)) {
                theList = list;
            }
        }
        return theList;

    }


    public ArrayList<TodoList> getLists() {
        return lists;
    }


}
