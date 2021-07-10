/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import java.lang.String;
import java.time.LocalDate;

public class AddTask {

    public void addNewTask(ListView<NewTask> taskList,
                           TextField description, DatePicker date,
                           Label errorLabel, ObservableList<NewTask> list,
                           NewTask editedTask) {
        errorLabel.setText("");
        // Check that input from TextField is valid
        if (inputIsValid(errorLabel, description, date)) {
            // Add the task to the TableView
            commitNewTask(errorLabel, taskList, description, date, list, editedTask);
        }
    }

    // Check that the input provided is valid
    public boolean inputIsValid(Label errorLabel, TextField description, DatePicker date) {

        if (date.getValue().isBefore(LocalDate.now())) {
            errorMessage(errorLabel, "Error: Date has already passed.");
            return false;
        }
        // Check that the TextField is not empty
        else if (description.getText().equals("")) {
            errorMessage(errorLabel, "Error: Description is empty.");
            return false;
        }
        // Check that the TextField does not exceed the 256 character limit
        else if (description.getText().length() > 256) {
            errorMessage(errorLabel, "Error: Description exceeds character limit.");
            return false;
        }

        return true;
    }

    // Add the data to the list
    public void commitNewTask(Label errorLabel, ListView<NewTask> taskList,
                              TextField description, DatePicker date,
                              ObservableList<NewTask> list, NewTask editTask) {
        // If a editTask is not null, we are editing something
        if (editTask != null) {
            // set the values inside the selected task to the current ones
            // inside the TextField and DatePicker
            list.remove(editTask);
            editTask.setDate(date.getValue());
            editTask.setDescription(description.getText());
            list.add(editTask);
        }
        else {
            // Add the data to the list
            list.add(new NewTask(description.getText(), date.getValue()));
        }
        // Add the NewTask item to the listview
        taskList.setItems(list);
        // Reset values as needed
        description.setText("");
        errorMessage(errorLabel,"");
        date.setValue(LocalDate.now());
    }

    public void errorMessage(Label errorLabel, String prompt) {
        errorLabel.setText(prompt);
        errorLabel.setTextFill(Color.RED);
    }
}
