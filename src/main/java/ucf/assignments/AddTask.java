/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.lang.String;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

// Figure out how to implement additions to the specific table column
// refresh the textview/datepicker/errorlabel for new input

public class AddTask {
    @FXML
    private TableColumn<NewTask, String> dateCol;
    @FXML
    private TableColumn<NewTask, String> descriptionCol;


    public void addNewTask(TableView<NewTask> taskList,
                           TextField description, DatePicker date,
                           Label errorLabel, ObservableList<NewTask> list) {
        // Check that input from TextField is valid
        if (inputIsValid(errorLabel, description, date)) {
            // Add the task to the TableView
            commitNewTask(errorLabel, taskList, description, date, list);
        }
    }

    public boolean inputIsValid(Label errorLabel, TextField description, DatePicker date) {
        // Check that the TextField is not empty

        if (description.getText().equals("")) {
            errorMessage(errorLabel, "Error: Description is empty.");
            return false;
        }
        // Check that the TextField does not exceed the 256 character limit
        else if (description.getText().length() > 256) {
            errorMessage(errorLabel, "Error: Description exceeds character limit.");
            return false;
        }
        else if (date.getValue().isBefore(LocalDate.now())) {
            errorMessage(errorLabel, "Error: Date has already passed.");
            return false;
        }

        return true;
    }

    public void commitNewTask(Label errorLabel, TableView<NewTask> taskList,
                              TextField description, DatePicker date,
                              ObservableList<NewTask> list) {
        // Add the data to an ArrayList
        list.add(new NewTask(description.getText(), date.getValue()));
        // Add the ArrayList data to the appropriate columns in the TableView

        // Reset the value inside of the TextField and DataPicker to today's date
        // for new input
        description.setText("");
        errorMessage(errorLabel,"");
        date.setValue(LocalDate.now());
    }

    public void errorMessage(Label errorLabel, String prompt) {
        errorLabel.setText(prompt);
        errorLabel.setTextFill(Color.RED);
    }
}
