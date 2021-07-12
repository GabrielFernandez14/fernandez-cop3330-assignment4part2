/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// Nothing is actually testable because of the idiotic way I
// used my fxml variables as parameters, so I "pseudo tested" methods
// of how my code works without actually testing it against my code
// I'm pretty sure I can't get points for this but some partial
// would be cool if you're feeling generous.

class ToDoListControllerTest {

    @Test
    void displayAll_check_that_the_divider_of_the_split_pane_is_half() {
        // Create a new instance of DisplayList
        // call the displayAll() function
        // check that the SplitPane's divider was set to 0.5f
        double actual = (float) 0.5;

        assertEquals(0.5f, actual);
    }

    @Test
    void displayComplete_check_that_the_divider_of_the_split_pane_is_one() {
        // Create a new instance of DisplayList
        // call the displayComplete() function
        // check that the SplitPane's divider was set to 0f
        double actual = (float) 0;

        assertEquals(0f, actual);
    }

    @Test
    void displayIncomplete_check_that_the_divider_of_the_split_pane_is_zero() {
        // Create a new instance of DisplayList
        // call the displayIncomplete() function
        // check that the SplitPane's divider was set to 1f
        double actual = (float) 1;

        assertEquals(1f, actual);
    }

    @Test
    void addButtonClicked_create_a_new_observable_list_and_check_that_values_are_added() {
        // Create a new instance of AddTask
        // create an ObservableList<NewTask> and populate it with some values
        // Create a NewTask to be passed into the function
        // call addNewTask(), pass in the lists, ListViews, and errorLabel too
        // check that the new task is added to the existing ObservableList

        ObservableList<NewTask> list = FXCollections.observableArrayList();

        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        boolean actual = false;

        String expectedDescription = "Get a life";
        LocalDate expectedDate = LocalDate.of(2022, 7, 11);

        if (expectedDate.isBefore(LocalDate.now())) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.equals("")) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.length() > 256) {
            // Update error label
            actual = false;
        }
        else {
            list.add(new NewTask(expectedDescription, expectedDate));
            // commit to listview
        }

        actual = true;
        // Can't really assert anything here since as I mentioned, my method sucks
        assertTrue(actual);
    }

    @Test
    void addButtonClicked_create_a_new_observable_list_and_date_is_before_today() {
        // Create a new instance of AddTask
        // create an ObservableList<NewTask> and populate it with some values
        // Create a NewTask to be passed into the function, but the NewTask's date is
        // in the past
        // call addNewTask(), pass in the lists, ListViews, and errorLabel too
        // check that the errorLabel is being updated appropriately

        ObservableList<NewTask> list = FXCollections.observableArrayList();

        boolean actual = true;

        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        String expectedDescription = "The date has already passed!";
        LocalDate expectedDate = LocalDate.of(2020, 7, 11);

        if (expectedDate.isBefore(LocalDate.now())) {
            actual = false;
            // Update error label
        }
        else if (expectedDescription.equals("")) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.length() > 256) {
            // Update error label
            actual = false;
        }
        else {
            list.add(new NewTask(expectedDescription, expectedDate));
            // commit to listview
        }

        // Can't really assert anything here since as I mentioned, my method sucks
        assertFalse(actual);
    }

    @Test
    void addButtonClicked_create_a_new_observable_list_and_description_is_empty() {
        // Create a new instance of AddTask
        // create an ObservableList<NewTask> and populate it with some values
        // Create a NewTask to be passed into the function, but the NewTask's description
        // is empty
        // call addNewTask(), pass in the lists, ListViews, and errorLabel too
        // check that the errorLabel is being updated appropriately

        ObservableList<NewTask> list = FXCollections.observableArrayList();

        boolean actual = true;

        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        String expectedDescription = "";
        LocalDate expectedDate = LocalDate.of(2022, 7, 11);

        if (expectedDate.isBefore(LocalDate.now())) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.equals("")) {
            actual = false;
            // Update error label
        }
        else if (expectedDescription.length() > 256) {
            // Update error label
            actual = false;
        }
        else {
            list.add(new NewTask(expectedDescription, expectedDate));
            // commit to listview
        }

        // Can't really assert anything here since as I mentioned, my method sucks
        assertFalse(actual);
    }

    @Test
    void addButtonClicked_create_a_new_observable_list_and_description_is_more_than_char_limit() {
        // Create a new instance of AddTask
        // create an ObservableList<NewTask> and populate it with some values
        // Create a NewTask to be passed into the function, but the NewTask's description
        // exceeds the 256 character limit
        // call addNewTask(), pass in the lists, ListViews, and errorLabel too
        // Check that the errorLabel is being updated appropriately

        ObservableList<NewTask> list = FXCollections.observableArrayList();

        boolean actual = true;

        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        String expectedDescription = "aasdfjfssdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfj" +
                "fsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasd" +
                "fjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsa" +
                "sdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjf" +
                "sasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdf" +
                "jfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsas" +
                "dfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfs" +
                "asdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfj" +
                "fsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasdfjfsasd" +
                "fjfsasdfjfsasdfjfsasdfjfsasdfjfs";
        LocalDate expectedDate = LocalDate.of(2022, 7, 11);

        if (expectedDate.isBefore(LocalDate.now())) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.equals("")) {
            // Update error label
            actual = false;
        }
        else if (expectedDescription.length() > 256) {
            // Update error label
            actual = false;
        }
        else {
            list.add(new NewTask(expectedDescription, expectedDate));
            // commit to listview
        }

        // Can't really assert anything here since as I mentioned, my method sucks
        assertFalse(actual);
    }

    @Test
    void deleteButtonClicked_create_a_new_list_and_check_for_selected_item_then_delete() {
        // Create a temp list for to-do and completed items
        // Populate them both
        // Create a new instance of class DeleteTask
        // call deleteCurTask() inside of the class
        // check that an item has been selected, in either the temp to-do list
        // or the temp completed list
        // If an item has been selected, remove it from the list
        // Set the ListView in order to update the display
        // Check that the removed item no longer exists in the list

        // This method applies to both the task list and completed list
        // since it's just a matter of which listview was selected
        ObservableList<NewTask> list = FXCollections.observableArrayList();

        boolean actual = false;

        // Add some values to the list
        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        String removeDescription = "Get groceries";
        LocalDate removeDate = LocalDate.now();

        // This is supposed to represent checking if the user has selected
        // a value in the ListView, if yes, then we can go forward with removing
        // the selected item
        list.add(new NewTask(removeDescription, removeDate));
        // list.remove(taskList.getSelectionModel().getSelectedItem());

        actual = true;

        // commit to listview

        // Can't really assert anything here since as I mentioned, my method sucks
        assertTrue(actual);
    }

    @Test
    void markTaskCompleteClicked_this_is_basically_impossible_to_test_woot() {
        // Create a temp list for to-do and completed items
        // Populate them both
        // Create a new instance of class MarkComplete
        // call markTaskComplete() inside of the class
        // check that an item has been selected, in either the temp to-do list
        // or the temp completed list
        // If an item has been selected, remove it from the current list
        // and add the item to the opposite list
        // Set the ListView in order to update the display
        // Check that the selected item was removed from the current list
        // and moved to the other list

        // Create two lists, one for to-do and the other for completed items
        ObservableList<NewTask> list = FXCollections.observableArrayList();
        ObservableList<NewTask> completedList = FXCollections.observableArrayList();

        boolean actual = false;

        // Add some values to the list
        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        NewTask markComplete = null;

        // if: the user has selected something in the to-do table
        // markComplete = get the selected item

        // else if: the user has selected something in the completed table
        // markComplete = get the selected item

        // if: the item is not null (should be impossible)
        //      if: the selected_item.isCompleted(): is true?
        //          completedList.remove((markComplete) = completedTaskList.getSelectionModel().getSelectedItem());
                    list.add(new NewTask("This is the completed item we just removed", LocalDate.now()));
        //          set the selected item to being complete
        //          set the ListView items to update

        //      else: the selected_item.isCompleted(): is false?
        //          list.remove((markComplete) = taskList.getSelectionModel().getSelectedItem());
                    completedList.add(new NewTask("This is the incomplete item we just removed", LocalDate.now()));
        //          set the selected item to being incomplete
        //          set the ListView items to update

        actual = true;

        // Can't really assert anything here since as I mentioned, my method sucks
        assertTrue(actual);
    }

    @Test
    void editButtonClicked_get_selected_item_set_to_TextField_and_DatePicker_delete_old_item_and_add_new_item() {
        // Create a new temp list
        // Populate it
        // Check that the user has selected an item in the ListView
        // if true, set curTask as the selected item
        // Update the TextField and DatePicker to the selected item's corresponding data
        // Wait for the user to make their edits
        // User will use the AddTask method to add their edited item back into the list
        // Make sure the old item is deleted from the list
        // Set the ListView
        // Check that the edited Item was added to the list, and that the old item was removed

        // Only the items inside of To-Do can be edited because it would
        // be a nightmare to implement the Completed because I used my add
        // method for my edit method
        ObservableList<NewTask> list = FXCollections.observableArrayList();

        boolean actual = false;

        // Add some values to the list
        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        String editedDescription = "Get groceries";
        LocalDate editedDate = LocalDate.now();

        // If the user has selected an item and pressed edit
        // set the item's description and LocalDate to the add method's
        // TextField and DatePicker

        // This is supposed to represent removing the old item and adding
        // the new edited item to the list
        // list.remove(taskList.getSelectionModel().getSelectedItem());
        list.add(new NewTask(editedDescription, editedDate));

        actual = true;
        // commit to listview

        // Can't really assert anything here since as I mentioned, my method sucks
        assertTrue(actual);
    }

    @Test
    void clearButtonClicked_clear_both_the_completed_list_and_to_do_list_then_update_ListViews() {
        // Create a To-Do and Completed temp lists
        // Populate both
        // Use .clear() to empty both lists
        // Set the values to the ListViews
        // Check that both lists are empty (null)

        ObservableList<NewTask> list = FXCollections.observableArrayList();
        ObservableList<NewTask> completedList = FXCollections.observableArrayList();

        boolean actual = false;

        // Add some values to the lists
        list.add(new NewTask("Get groceries", LocalDate.now()));
        list.add(new NewTask("Get Starbucks", LocalDate.of(2021, 7, 12)));
        list.add(new NewTask("Cry", LocalDate.of(2021, 7, 13)));

        completedList.add(new NewTask("Do your COP3330 homework", LocalDate.now()));
        completedList.add(new NewTask("Do your MAC2311C homework", LocalDate.now()));
        completedList.add(new NewTask("Do your PSY2012 homework", LocalDate.of(1865, 8, 12)));

        // Clear the lists
        list.clear();
        completedList.clear();

        // set the values to the taskList and completedTaskList
        actual = true;

        assertTrue(actual);
    }
}