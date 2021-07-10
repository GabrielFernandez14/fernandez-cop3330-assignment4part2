/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

import java.io.IOException;
import java.util.Objects;

public class EditTask {

    public void editCurTask(ObservableList<NewTask> list,
                            ListView<NewTask> listView, TextField description,
                            DatePicker date, NewTask curTask) {
        if (inputIsValid(description, date)) {
            list.add(new NewTask(description.getText(), date.getValue()));
            list.remove(curTask);
            listView.setItems(list);
        }
    }

    // Check that the input provided is valid
    public boolean inputIsValid(TextField description, DatePicker date) {
        if (date.getValue().isBefore(LocalDate.now())) {
            return false;
        }
        // Check that the TextField is not empty
        else if (description.getText().equals("")) {
            return false;
        }
        // Check that the TextField does not exceed the 256 character limit
        else if (description.getText().length() > 256) {
            return false;
        }

        return true;
    }
}
