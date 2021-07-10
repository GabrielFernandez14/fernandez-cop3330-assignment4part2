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
        // get the highlighted item
        list.remove(taskList.getSelectionModel().getSelectedItem());
        completedList.remove(taskCompletedList.getSelectionModel().getSelectedItem());
        // update the ListView
        taskList.refresh();
        taskCompletedList.refresh();
        // reset the selection for future selections
        taskList.getSelectionModel().clearSelection();
        taskCompletedList.getSelectionModel().clearSelection();
    }
}
