package com.joelwarburton.todo.core;

import java.time.LocalDate;
import java.util.Date;

public class Task {


    private boolean isComplete;
    private String title;
    private final int ID;
    private final LocalDate dateCreated;
    private LocalDate dateDue;
    private String note;
    private int repeatFrequency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (ID != task.ID) return false;
        return title.equals(task.title);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + ID;
        return result;
    }

    public Task(int ID, String title) {
        this(ID, title, "", false, LocalDate.now(), null, 0);
    }

    public Task(String[] data) {
        this.ID = Integer.parseInt(data[0]);
        this.title = data[2];
        this.note = data[3];
        this.isComplete = Boolean.valueOf(data[4]);
        this.dateCreated = LocalDate.parse(data[5]);

        if(!data[6].equals("null")) {
            this.dateDue =  LocalDate.parse(data[6]);
        } else {
            this.dateDue = null;
        }
        this.repeatFrequency = Integer.parseInt(data[7]);
    }

    public Task(int ID, String title, String note, boolean isComplete, LocalDate dateCreated, LocalDate dateDue, int repeatFrequency) {
        this.ID = ID;
        this.title = title;
        this.note ="";
        this.isComplete = isComplete;
        this.dateCreated = dateCreated;

        this.dateDue = dateDue;
        this.repeatFrequency = repeatFrequency;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRepeatFrequency() {
        return repeatFrequency;
    }

    public void setRepeatFrequency(int repeatFrequency) {
        this.repeatFrequency = repeatFrequency;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean isComplete() {
        return isComplete;
    }


    @Override
    public String toString() {
        return this.title + ": " + this.isComplete;
    }

}
