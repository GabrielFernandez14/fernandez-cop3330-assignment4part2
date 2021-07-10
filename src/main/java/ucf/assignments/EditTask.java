/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditTask {

    public void editCurTask(TextField description,
                            DatePicker date, NewTask curTask) {
        // Set the TextField and DatePicker to the date and description
        // of the selected item
        description.setText(curTask.getDescription());
        date.setValue(curTask.getDate());
    }
}
