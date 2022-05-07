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


        //Build the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(500, 500);


        listPane = new ListPane(this);
        listPane.setPrefWidth(150);
        mainLayout.setLeft(listPane);
        System.out.println(lists);
        if (listPane.getListItem(0) == null) {
            TodoView todoView = new TodoView();
            mainLayout.setCenter(todoView);

            // Label empty = new Label("There are no lists. Create one!");
            //mainLayout.setCenter(empty);
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
