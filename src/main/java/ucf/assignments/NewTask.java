/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

// Creates a new instance of a task for the list
public class NewTask implements Serializable {
    private LocalDate date;
    private String description;
    private boolean isComplete;

    // Specify as a new element using 'this.'
    public NewTask(String description, LocalDate date) {
        this.description = description;
        this.date = date;
        this.isComplete = false;
    }

    // getter and setter for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isComplete;
    }

    public void setCompleted (boolean isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return date.toString() + "\t|||\t"+ description;
    }
}
