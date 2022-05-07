package com.joelwarburton.todo.gui;

import com.joelwarburton.todo.core.TodoCoord;
import com.joelwarburton.todo.core.TodoList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * This class is used to coordinate between the core application and the gui elements
 * */
public class UI extends Application {

    private TodoCoord todo;
    private ListPane listPane;
    private ArrayList<TodoList> lists;

    @Override
    public void init() {
        lists = new ArrayList<>();
        todo = new TodoCoord();
        System.out.println(todo.getLists());
    }


    @Override
    public void start(Stage window) {
        /*
        * The main view should have two sub-views by default.
        * the list pane on the left which houses all the lists and functions to add or remove lists
        * on the right is the selected list which contains the tasks in that list.
        * */

        //Build the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(500, 500);

        /*Set up the list pane for display*/
        listPane = new ListPane(this);
        listPane.setPrefWidth(150);
        mainLayout.setLeft(listPane);

        /*display the selected list. If a list does not exist display a placeholder */
        System.out.println(lists);
        if (listPane.getListItem(0) == null) {
            TodoView todoView = new TodoView();
            mainLayout.setCenter(todoView);

             Label empty = new Label("There are no lists. Create one!");
             mainLayout.setCenter(empty);
        } else {
            TodoView todoView = new TodoView();
            mainLayout.setCenter(todoView);
        }

        Scene scene = new Scene(mainLayout);

        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(UI.class);


    }

}
