package com.joelwarburton.todo.core;



import java.time.LocalDate;
import java.util.ArrayList;


public class TodoList {



    private ArrayList<Task> tasks;
    private String name;


    public TodoList(String name) {

        this.name = name;
        tasks = new ArrayList<>();
    }

    public String getName() {
        return this.name;

    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }


    /*Add the new task*/
    public void addTask(int ID, String taskName) {
        this.tasks.add(new Task(ID, taskName));
    }


    /*Add the task from load data*/
    public void addTask(String[] data) {

        this.tasks.add(new Task(data));
    }



    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }


    public void markComplete(Task task) {
        for(int i = 0; i < tasks.size(); i++) {
           if (tasks.get(i).equals(task)) {
               tasks.get(i).setComplete(true);
            }
        }
    }




    @Override
    public String toString() {
        return this.name + " contains " + this.tasks.size() + " tasks";
    }



}
