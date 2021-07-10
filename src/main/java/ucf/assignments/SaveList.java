/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;


public class SaveList {
    private int counter = 1;

    public void saveFile(BorderPane mainPane, FileChooser fileChooser) {
        // Use the file chooser to set initial title and file name
        Window window = mainPane.getScene().getWindow();
        fileChooser.setTitle("Save To-Do List");
        fileChooser.setInitialFileName("todolist" + counter);
        counter++;
        // Create options for user to save file as (jar)
        fileChooser.getExtensionFilters().addAll
                (new FileChooser.ExtensionFilter("jar file", ".jar"));
        // Open the File Explorer and set initial directory
        try {
            File file = fileChooser.showSaveDialog(window);
            fileChooser.setInitialDirectory(file.getParentFile());
            //TODO save contents of the application somehow
        }
        // crash if there is an issue
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
