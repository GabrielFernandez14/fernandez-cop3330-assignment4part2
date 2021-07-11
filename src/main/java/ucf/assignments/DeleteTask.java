/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class DeleteTask {

    public void deleteSelectedTask(ObservableList<NewTask> list, ListView<NewTask> taskList,
                                   ObservableList<NewTask> completedList,
                                   ListView<NewTask>taskCompletedList) {
        // get the selected item
        // (If two items are selected, one in each table,
        // the program prioritizes the one in the To-Do list)
        if (taskList.getSelectionModel().getSelectedItem() != null) {
            list.remove(taskList.getSelectionModel().getSelectedItem());
        }
        else if (taskCompletedList.getSelectionModel().getSelectedItem() != null
                && taskList.getSelectionModel().getSelectedItem() == null) {
            completedList.remove(taskCompletedList.getSelectionModel().getSelectedItem());
        }
        // update the ListView
        taskList.refresh();
        taskCompletedList.refresh();
        // reset the selections that were made
        taskList.getSelectionModel().clearSelection();
        taskCompletedList.getSelectionModel().clearSelection();
    }
}
