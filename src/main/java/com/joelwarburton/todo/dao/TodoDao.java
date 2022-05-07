package com.joelwarburton.todo.dao;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class TodoDao {

    //TODO write an IO to save todo lists as a set of txt files.
    public ArrayList<String> loadData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("ListOne,ListOne,ListOne,ListOne,ListOne");
        data.add("15");
        LocalDate dateC = LocalDate.now();
        data.add("5,ListOne,The Best Task,,false,"+ dateC+",null,1");

        return data;
        //return new ArrayList<>();
    }
}
