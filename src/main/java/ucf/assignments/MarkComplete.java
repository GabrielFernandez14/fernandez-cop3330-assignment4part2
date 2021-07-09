/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import java.time.LocalDate;

public class MarkComplete {

    public void markTaskComplete(ObservableList<NewTask> list, ListView<NewTask> taskList,
                                 ObservableList<NewTask> completedList, ListView<NewTask> taskCompletedList) {

        // Get selected list item
        NewTask curTask = null;

        // Check if a value is highlighted by the user and get that item
        if (taskList.isFocused()) {
            curTask = taskList.getSelectionModel().getSelectedItem();
        }
        else if (taskCompletedList.isFocused()) {
            curTask = taskCompletedList.getSelectionModel().getSelectedItem();
        }

        // Check that the selected item exists
        if (curTask != null) {
            // Check if the item is already in the completed ListView
            if (curTask.isCompleted()) {
                // The item is marked as complete already, so mark as incomplete
                // add the data from the completed list into the task
                // list and set to the correct ListView
                completedList.remove(curTask);
                list.add(curTask);
                curTask.setCompleted(false);
                curTask.setDate(null);
                taskList.setItems(list);
            }
            else {
                // If the item is not in the normal ListView, mark as complete
                // add the data from the task list into the completed
                // list and set to the correct ListView
                list.remove(curTask);
                completedList.add(curTask);
                curTask.setCompleted(true);
                curTask.setDate(LocalDate.now());
                taskCompletedList.setItems(completedList);
            }
        }
    }
}
