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
import javafx.stage.FileChooser;
import java.io.File;
import java.time.LocalDate;

public class ToDoListController {
    // Declare all FXML variables as public
    @FXML
    public BorderPane mainPane;
    @FXML
    public SplitPane splitPane;
    @FXML
    public Label errorLabel;
    @FXML
    public DatePicker selectDate;
    @FXML
    public TextField descriptionText;
    @FXML
    public Button addButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button markCompleteButton;
    @FXML
    public Button clearButton;
    @FXML
    public Button editTaskButton;
    @FXML
    public ListView<NewTask> taskList;
    @FXML
    public ListView<NewTask> completedList;


    // Create two ObservableLists, one for the To-Do column, and the other for completed
    public ObservableList<NewTask> list = FXCollections.observableArrayList();
    public ObservableList<NewTask> completed = FXCollections.observableArrayList();

    // Make other variables as needed
    public FileChooser fileChooser = new FileChooser();
    public NewTask curTask = null;

    // Set initial values for TextFields and FileChooser etc.
    @FXML
    public void initialize() {
        selectDate.setValue(LocalDate.now());
        descriptionText.setText("");
        errorLabel.setText("");
        fileChooser.setInitialDirectory(new File("user.home"));
        // I tried to make the SplitPane divider uneditable
        // but couldn't figure it out :/, .setMouseTransparent() wasn't working
    }

    // ToDo NOT WORKING
    @FXML
    public void saveToExternal(ActionEvent actionEvent) {
        errorLabel.setText("");
        // Create a new instance of class SaveList
        SaveList save = new SaveList();
        // call saveFile()
        save.saveFile(mainPane, fileChooser);
    }

    // ToDo Empty method
    @FXML
    public void loadFromExternal(ActionEvent actionEvent) {
        errorLabel.setText("");

        // Can't really make a load method when your save method isn't working
        // Create a new instance of class LoadList
        LoadList load = new LoadList();
        // call loadFromFile()
        load.loadFromFile();
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
}
