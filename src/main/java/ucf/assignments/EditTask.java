/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class EditTask {

    public void editCurTask(ObservableList<NewTask> list,
                            ListView<NewTask> listView, TextField description,
                            DatePicker date, NewTask curTask) {
        if (inputIsValid(description, date)) {
            // Add the updated value to the current list
            list.add(new NewTask(description.getText(), date.getValue()));
            // Remove the old value from the list
            list.remove(curTask);
            // update the list
            listView.setItems(list);
        }
    }

    // Check that the input provided is valid
    public boolean inputIsValid(TextField description, DatePicker date) {
        // Check that the date is not in the past
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
