/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

// Figure out how to implement additions to the specific table column
// refresh the textview/datepicker/errorlabel for new input

public class AddTask {

    public void addNewTask(TableView<NewTask> taskList,
                           TextField description, DatePicker date,
                           Label errorLabel, ObservableList<NewTask> list) {
        // Check that input from TextField is valid
        if (inputIsValid(errorLabel, description)) {
            // Add the task to the TableView
            commitNewTask(errorLabel, taskList, description, date, list);
        }
    }

    public boolean inputIsValid(Label errorLabel, TextField description) {
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

        return true;
    }

    public void commitNewTask(Label errorLabel, TableView<NewTask> taskList,
                              TextField description, DatePicker date,
                              ObservableList<NewTask> list) {
        // Add the data to an ArrayList
        list.add(new NewTask(description.getText(), date.getValue()));
        // columns need to be initialized before we can call on them and set
        // their values

        // Add the ArrayList data to the appropriate columns in the TableView
        taskList.setItems(list);
        /*
        final HBox hb = new HBox();
        hb.getChildren().addAll(description, date);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(description, date, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
         */

        // Reset the value inside of the TextField and DataPicker to today's date
        // for new input
        description.setText("");
        errorMessage(errorLabel,"");
        date.setValue(LocalDate.now());
    }

    public void errorMessage(Label errorLabel, String prompt) {
        errorLabel.setText(prompt);
    }
}
