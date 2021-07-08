/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.time.LocalDate;

public class ToDoListController {
    @FXML
    private BorderPane mainPane;
    @FXML
    private SplitPane splitPane;
    // Error label is being weird
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
    private TableView<NewTask> taskList;
    @FXML
    private TableView<NewTask> completedList;

    ObservableList<NewTask> list = FXCollections.observableArrayList();
    ObservableList<NewTask> listComplete = FXCollections.observableArrayList();

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
        Scene scene = mainPane.getScene();
        // Call addNewTask() function inside of AddTask
        task.addNewTask(taskList, descriptionText, selectDate, errorLabel, list);
    }

    @FXML
    public void deleteButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void markTaskCompleteClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void clearButtonClicked(ActionEvent actionEvent) {
    }
}
