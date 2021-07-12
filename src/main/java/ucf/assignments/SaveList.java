/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveList {

    public String saveFile() {
        // Create a new FileChooser
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter
                ("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save To-Do List");
        //Show save file dialog
        File file = fileChooser.showSaveDialog(null);

        // Return the path that the user selects
        if (file != null) {
            return file.getAbsolutePath();
        }

        return "";
    }

    public static void writeToFile(String path, ObservableList<NewTask> list,
                                   ObservableList<NewTask> completedList) {
        // Use a BufferedWriter to write the contents of the to-do lists
        // and completed lists to the previously established .txt file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write("To-Do\n");
            for (NewTask toDoTask: list) {
                bw.write(String.format("%-10s |\t%-10s\n",
                        toDoTask.getDate(), toDoTask.getDescription()));
            }
            bw.write("Completed Tasks\n");
            for (NewTask completeTask: completedList) {
                bw.write(String.format("%-10s |\t%-10s\n",
                        completeTask.getDate(), completeTask.getDescription()));
            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
