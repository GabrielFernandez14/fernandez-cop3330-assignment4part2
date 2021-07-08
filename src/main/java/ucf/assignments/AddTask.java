/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.awt.*;

// Figure out how to implement additions to the specific table column
// refresh the textview/datepicker/errorlabel for new input

public class AddTask {

    public void addNewTask(TableView<NewTask> taskList,
                           TextField description, DatePicker date,
                           Label errorLabel, ObservableList<NewTask> list) {
        // Check that input from TextField is valid
        if (inputIsValid(errorLabel, description)) {
            // Add the task to the TableView
            commitNewTask(taskList, description, date, list);
        }
    }

    public boolean inputIsValid(Label errorLabel, TextField description) {
        // Check that the TextField is not empty
        if (description.getText().equals("")) {
            errorMessage(errorLabel, " Description is empty.");
            return false;
        }
        // Check that the TextField does not exceed the 256 character limit
        else if (description.getText().length() > 256) {
            errorMessage(errorLabel, " Description exceeds character limit.");
            return false;
        }

        return true;
    }

    public void commitNewTask(TableView<NewTask> taskList,
                              TextField description, DatePicker date,
                              ObservableList<NewTask> list) {
        // Add the data to an ArrayList
        list.add(new NewTask(description.getText(), date.getValue()));
        // columns need to be initialized before we can call on them and set
        // their values

        // Add the ArrayList data to the appropriate columns in the TableView
        taskList.getColumns();
        // Reset the value inside of the TextField and DataPicker to today's date
        // for new input
    }

    public void errorMessage(Label errorLabel, String prompt) {
        errorLabel.setText("Error:" + prompt);
    }
}
