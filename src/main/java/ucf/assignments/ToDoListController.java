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
import javafx.scene.layout.BorderPane;

public class ToDoListController {
    @FXML
    private BorderPane mainPane;
    @FXML
    private SplitPane splitPane;
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
    private ListView<ToDoTask> taskList;
    @FXML
    private ListView<ToDoTask> completedList;

    ObservableList<ToDoTask> list = FXCollections.observableArrayList();
    ObservableList<ToDoTask> listComplete = FXCollections.observableArrayList();

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
