package com.joelwarburton.todo.gui;

import com.joelwarburton.todo.core.Task;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TodoView  extends BorderPane {

    ArrayList<Task> todoList;

    public TodoView() {
        todoList = new ArrayList<>();
        initTodoView();
    }

    private void initTodoView() {

       this.setPadding(new Insets(5));

        VBox taskContainer = new VBox();

        HBox task = new HBox();

        CheckBox taskComplete = new CheckBox();
        Label taskName = new Label("A task is named here");
        task.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5), new Insets(0))));
        task.setPadding(new Insets(10));
        task.setPrefHeight(30);

        HBox task2 = new HBox();
        task2.setOnMouseEntered(mouseEvent -> {
            task2.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), new Insets(0))));
        });

        task2.setOnMouseExited(mouseEvent -> {
            task2.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5), new Insets(0))));

        });

        CheckBox taskComplete2 = new CheckBox();
        Label taskName2 = new Label("This is the second task");
        task2.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5), new Insets(0))));
        task2.setPadding(new Insets(10));
        task2.setPrefHeight(30);


        Label addTaskLabel = new Label("add task");

        task.getChildren().addAll(taskComplete, taskName);
        task2.getChildren().addAll(taskComplete2, taskName2);
        taskContainer.getChildren().addAll(task, task2);
        this.setCenter(taskContainer);
        this.setBottom(addTaskLabel);
    }

    public BorderPane getView() {
        return this;
    }

}
