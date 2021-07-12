/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoListController {
    // Declare all FXML variables as private
    @FXML
    private BorderPane mainPane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private Label errorLabel;
    @FXML
    private DatePicker selectDate;
    @FXML
    private TextField descriptionText;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button markCompleteButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button editTaskButton;
    @FXML
    private ListView<NewTask> taskList;
    @FXML
    private ListView<NewTask> completedList;

    // Create two ObservableLists, one for the To-Do column, and the other for completed
    public ObservableList<NewTask> list = FXCollections.observableArrayList();
    public ObservableList<NewTask> completed = FXCollections.observableArrayList();

    // Make other variables as needed
    public NewTask curTask = null;

    // Set initial values for TextFields and FileChooser etc.
    @FXML
    public void initialize() {
        selectDate.setValue(LocalDate.now());
        descriptionText.setText("");
        errorLabel.setText("");
        // I tried to make the SplitPane divider uneditable
        // but couldn't figure it out :/, .setMouseTransparent() wasn't working
    }

    @FXML
    public void saveToExternal(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class SaveList
        SaveList save = new SaveList();
        // call saveFile()
        String getPath = save.saveFile();

        // Check that the path is not null
        if (!getPath.equals("")) {
            // write our entire list to the .txt file
            SaveList.writeToFile(getPath, list, completed);
        }
    }

    @FXML
    public void loadFromExternal(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class LoadList
        LoadList load = new LoadList();

        // Create a FileChooser for opening files
        String getPath = load.loadFile();

        // Store the data from the file into ArrayList<String> for both
        // tasks in the to-do column and in the completed
        ArrayList<String> toDoTasks = LoadList.readToDoTasks(getPath);
        ArrayList<String> completeTasks = LoadList.readCompleteTasks(getPath);

        // Check that the path is not null
        if (!getPath.equals("")) {
            // clear the current stuff that is inside the list to make room for
            // the file's data
            list.clear();
            completed.clear();
            // Loop through the arraylist and convert the data into LocalDate
            // and String so we can add it as new instance of NewTask
            for (int i = 0; i < toDoTasks.size(); i++) {
                LocalDate curDate = readDate(toDoTasks, i);
                String curDescription = readDescription(toDoTasks, i);
                // Add the data to the list as a new instance of NewTask
                list.add(new NewTask(curDescription, curDate));
            }
            // Repeat for completed tasks as well
            for (int i = 0; i < completeTasks.size(); i++) {
                LocalDate curCompletedDate = readDate(completeTasks, i);
                String curCompletedDescription = readDescription(completeTasks, i);
                completed.add(new NewTask(curCompletedDescription, curCompletedDate));
            }
        }

        // Set the items to the ListView
        taskList.setItems(list);
        completedList.setItems(completed);
    }

    @FXML
    public void displayAll(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayAll()
        display.displayAll(splitPane);
    }

    @FXML
    public void displayComplete(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayComplete()
        display.displayComplete(splitPane);
    }

    @FXML
    public void displayIncomplete(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayIncomplete()
        display.displayIncomplete(splitPane);
    }

    @FXML
    public void addButtonClicked(ActionEvent actionEvent) {
        errorLabel.setText("");

        markCompleteButton.setDisable(false);
        deleteButton.setDisable(false);
        clearButton.setDisable(false);
        // Create a new instance of AddTask Class
        AddTask task = new AddTask();
        // Call addNewTask() function inside of AddTask
        task.addNewTask(taskList, descriptionText, selectDate,
                errorLabel, list, curTask);

        curTask = null;
    }

    @FXML
    public void deleteButtonClicked(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class DeleteTask
        DeleteTask delete = new DeleteTask();
        // Call deleteSelectedTask() inside of the class
        delete.deleteSelectedTask(list, taskList, completed, completedList);
    }

    @FXML
    public void markTaskCompleteClicked(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class MarkComplete
        MarkComplete complete = new MarkComplete();
        // call markTaskComplete() function
        complete.markTaskComplete(list, taskList, completed, completedList);
    }

    @FXML
    public void clearButtonClicked(ActionEvent actionEvent) {
        // Create a new instance of ClearList
        ClearList clear = new ClearList();
        // call clearAll()
        clear.clearAll(list, taskList, completed, completedList);
    }

    @FXML
    public void editButtonClicked(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Create a new instance of class EditTask
        EditTask edit = new EditTask();

        // Check whether the current item is in the To-Do column or Completed column
        if (taskList.getSelectionModel().getSelectedItem() != null) {
            markCompleteButton.setDisable(true);
            deleteButton.setDisable(true);
            clearButton.setDisable(true);
            // Set a curTask value as the item and pass it into editCurTask() function
            curTask = taskList.getSelectionModel().getSelectedItem();
            edit.editCurTask(descriptionText, selectDate, curTask);
            //add.addNewTask(taskList, descriptionText, selectDate, errorLabel, list);
        }
        else if (completedList.getSelectionModel().getSelectedItem() != null) {
            printError("Error: Cannot edit a completed task.");
        }
        else {
            printError("Error: You must select a task before you can edit.");
        }
    }

    public void printError(String prompt) {
        // Set whatever the prompt says to the TextField
        errorLabel.setText(prompt);
        errorLabel.setTextFill(Color.RED);
    }

    public LocalDate readDate(ArrayList<String> fileItem, int index) {
        // Use a regex to distinguish between the date String and the descriptionString
        String[] split = fileItem.get(index).split("\\|");
        // return the date String as a LocalDate
        return LocalDate.parse(split[0].trim());
    }

    public String readDescription(ArrayList<String> fileItem, int index) {
        // Use a regex to distinguish between the date String and the descriptionString
        String[] split = fileItem.get(index).split("\\|");
        // return the description
        return split[1].trim();
    }
}
