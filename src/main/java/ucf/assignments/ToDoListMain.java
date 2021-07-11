/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ToDoListMain extends Application {

    // Launch the javafx application
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull
                    (getClass().getResource("ListWindow.fxml")));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("To-Do List Application");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

