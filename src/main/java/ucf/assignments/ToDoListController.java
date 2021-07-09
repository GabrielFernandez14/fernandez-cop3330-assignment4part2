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
import java.time.LocalDate;


public class ToDoListController {
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
    private ListView<NewTask> taskList;
    @FXML
    private ListView<NewTask> completedList;

    ObservableList<NewTask> list = FXCollections.observableArrayList();
    ObservableList<NewTask> completed = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        selectDate.setValue(LocalDate.now());
        descriptionText.setText("");
    }

    @FXML
    public void saveToExternal(ActionEvent actionEvent) {
    }

    @FXML
    public void loadFromExternal(ActionEvent actionEvent) {
    }

    @FXML
    public void displayAll(ActionEvent actionEvent) {
    }

    @FXML
    public void displayComplete(ActionEvent actionEvent) {
    }

    @FXML
    public void displayIncomplete(ActionEvent actionEvent) {
    }

    @FXML
    public void openHelpWindow(ActionEvent actionEvent) {
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

    // NOT WORKING YET, COME BACK TO THIS
    @FXML
    public void markTaskCompleteClicked(ActionEvent actionEvent) {
        // Create a new instance of class MarkComplete
        MarkComplete complete = new MarkComplete();
        // call markTaskComplete() function
        complete.markTaskComplete(list, taskList, completed, completedList);
    }

    /*
    Not sure if I need to implement these or not

    @FXML
    public void listClicked(MouseEvent mouseEvent) {
        //deleteButton.setDisable(list.isEmpty());
        markCompleteButton.setDisable(list.isEmpty());
        taskList.getSelectionModel().clearSelection();
    }

    @FXML
    public void completedLIstClicked(MouseEvent mouseEvent) {
        //deleteButton.setDisable(completed.isEmpty());
        markCompleteButton.setDisable(completed.isEmpty());
        completedList.getSelectionModel().clearSelection();
    }
     */


    @FXML
    public void clearButtonClicked(ActionEvent actionEvent) {
    }
}
