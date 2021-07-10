/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

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
    @FXML
    public DatePicker editDate;
    @FXML
    public TextField editDescription;
    @FXML
    public Button confirmEditButton;

    // Create two ObservableLists, one for the To-Do column, and the other for completed
    public ObservableList<NewTask> list = FXCollections.observableArrayList();
    public ObservableList<NewTask> completed = FXCollections.observableArrayList();

    // Make other variables as needed
    public FileChooser fileChooser = new FileChooser();
    public NewTask curTask = null;
    public final Stage newStage = new Stage();


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
        // Create a new instance of class SaveList
        SaveList save = new SaveList();
        // call saveFile()
        save.saveFile(mainPane, fileChooser);
    }

    // ToDo Empty method
    @FXML
    public void loadFromExternal(ActionEvent actionEvent) {
        // Can't really make a load method when your save method isn't working
        // Create a new instance of class LoadList
        LoadList load = new LoadList();
        // call loadFromFile()
        load.loadFromFile();
    }

    @FXML
    public void displayAll(ActionEvent actionEvent) {
        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayAll()
        display.displayAll(splitPane);
    }

    @FXML
    public void displayComplete(ActionEvent actionEvent) {
        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayComplete()
        display.displayComplete(splitPane);
    }

    @FXML
    public void displayIncomplete(ActionEvent actionEvent) {
        // Create a new instance of class DisplayList
        DisplayList display = new DisplayList();
        // call displayIncomplete()
        display.displayIncomplete(splitPane);
    }

    @FXML
    public void addButtonClicked(ActionEvent actionEvent) {
        // Create a new instance of AddTask Class
        AddTask task = new AddTask();
        // Call addNewTask() function inside of AddTask
        task.addNewTask(taskList, descriptionText, selectDate, errorLabel, list);
    }

    @FXML
    public void deleteButtonClicked(ActionEvent actionEvent) {
        // Create a new instance of class DeleteTask
        DeleteTask delete = new DeleteTask();
        // Call deleteSelectedTask() inside of the class
        delete.deleteSelectedTask(list, taskList, completed, completedList);
    }

    @FXML
    public void markTaskCompleteClicked(ActionEvent actionEvent) {
        // Create a new instance of class MarkComplete
        MarkComplete complete = new MarkComplete();
        // call markTaskComplete() function
        complete.markTaskComplete(list, taskList, completed, completedList);
    }

    // ToDo program crashes
    @FXML
    public void editButtonClicked() {
        // Check if an item is selected, if true, then launch the edit window
        if (taskList.getSelectionModel().getSelectedItem() != null) {
            launchEditWindow();
        }
        else if (completedList.getSelectionModel().getSelectedItem() != null &&
                taskList.getSelectionModel().getSelectedItem() == null) {
            launchEditWindow();
        }
        else {
            printError("Error: You must select a task before you can edit.");
        }
    }

    // ToDo Crashing for some reason
    public void launchEditWindow() {
        // Open EditTaskWindow.fxml and crash if there is an issue
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull
                    (getClass().getResource("EditTaskWindow.fxml")));

            Scene scene = new Scene(root);

            newStage.setScene(scene);
            newStage.setTitle("Edit Task");
            newStage.setResizable(false);
            newStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clearButtonClicked(ActionEvent actionEvent) {
        // Create a new instance of ClearList
        ClearList clear = new ClearList();
        // call clearAll()
        clear.clearAll(list, taskList, completed, completedList);
    }

    public void printError(String prompt) {
        // Set whatever the prompt says to the TextField
        errorLabel.setText(prompt);
        errorLabel.setTextFill(Color.RED);
    }

    // ToDo NOT ACCESSIBLE (EditTaskWindow.fxml is not being launched)
    @FXML
    public void confirmEditClicked(ActionEvent actionEvent) {
        // Create a new instance of class EditTask
        EditTask edit = new EditTask();

        // Check whether the current item is in the To-Do column or Completed column
        if (taskList.getSelectionModel().getSelectedItem() != null) {
            // Set a curTask value as theh item and pass it into editCurTask() function
            curTask = taskList.getSelectionModel().getSelectedItem();
            edit.editCurTask(list, taskList, editDescription, editDate, curTask);
        }
        else if (completedList.getSelectionModel().getSelectedItem() != null &&
                taskList.getSelectionModel().getSelectedItem() != null) {
            curTask = completedList.getSelectionModel().getSelectedItem();
            edit.editCurTask(completed, completedList, editDescription, editDate,  curTask);
        }
    }
}
