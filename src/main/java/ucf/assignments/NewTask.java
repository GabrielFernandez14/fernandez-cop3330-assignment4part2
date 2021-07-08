/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

// Creates a new instance of a task for the list
@SuppressWarnings("serial")
public class NewTask implements Serializable {
    private LocalDate date;
    private String description;

    // Specify as a new element using 'this.'
    public NewTask(String description, LocalDate date) {
        super();
        this.description = description;
        this.date = date;
    }


    @Override
    public String toString() {
        return date.toString();
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

    public void setDescription(String description) {
        this.description = description;
    }
}
