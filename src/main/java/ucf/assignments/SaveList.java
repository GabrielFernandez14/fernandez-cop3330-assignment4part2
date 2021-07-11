/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveList {

    public String saveFile(ObservableList<NewTask> list, ListView<NewTask> taskList,
                         ObservableList<NewTask> completedList, ListView<NewTask> taskCompletedList) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter
                ("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save To-Do List");
        //Show save file dialog
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            return file.getAbsolutePath();
        }

        return "";
    }

    public static void writeToFile(String path, ObservableList<NewTask> list,
                                   ObservableList<NewTask> completedList) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write("To-Do\n");
            for (NewTask toDoTask: list) {
                bw.write(String.format("%-10s |\t%-10s\n",
                        toDoTask.getDate(), toDoTask.getDescription()));
            }
            bw.write("Completed Tasks\n");
            for (NewTask completeTask: list) {
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
