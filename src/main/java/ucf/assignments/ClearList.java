/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ClearList {
    public void clearAll(ObservableList<NewTask> list, ListView<NewTask> taskList,
                         ObservableList<NewTask> completedList, ListView<NewTask> taskCompletedList) {
        // Clear all items from each list
        list.clear();
        completedList.clear();

        // Update the lists
        taskList.refresh();
        taskCompletedList.refresh();
    }
}
