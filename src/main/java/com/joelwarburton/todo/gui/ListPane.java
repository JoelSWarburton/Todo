package com.joelwarburton.todo.gui;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ListPane extends BorderPane {

    private Label title;
    private BorderPane addButton;
    private VBox listSection;
    private UI uiCoord;
    private ArrayList<ListItem> lists;

    public ListPane(UI ui) {
        uiCoord = ui;
        title = new Label("List");
        addButton = new BorderPane();
        lists = new ArrayList<>();
        initListPane();
    }

    private void initListPane() {
        //sets up the list pane.
        this.prefWidth(150);
        this.setTop(title);
        this.setCenter(listSection);

        Label addListLabel = new Label("Add new list");
        Label left = new Label("+");

        //adjusts width of the left element
        left.setPrefWidth(15);
        addButton.setLeft(left);

        //makes the Add label fill space
        addListLabel.setPrefWidth(Double.MAX_VALUE);
        addButton.setRight(new Label("x"));
        addButton.setCenter(addListLabel);

        this.setBottom(addButton);

    }

    //gets the list item to generate the todoView
    public ListItem getListItem(int index) {
        if(lists.size() == 0) {
            return null;
        }
        return lists.get(index);
    }




}
