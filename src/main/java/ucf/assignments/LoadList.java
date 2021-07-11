/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadList {

    public String loadFile() {
        // Pretty much identical to saveFile() in SaveList
        // Create a new FileChooser
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter
                ("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open To-Do List");
        //Show save file dialog
        File file = fileChooser.showOpenDialog(null);

        // Return the path that the user selects
        if (file != null) {
            return file.getAbsolutePath();
        }

        return "";
    }

    public static ArrayList<String> readToDoTasks(String path) {
        // Read the To-Do tasks in the file
        // Create an ArrayList<String> to hold them
        ArrayList<String> toDoTasks = new ArrayList<>();
        // Use a buffered reader to read through the file and store the tasks
        // inside the array list
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            // Garbage value for the "To-Do" header
            String garbage = br.readLine();
            // Read through the tasks until we reach "Completed Tasks"
            String curLine = br.readLine();
            while (!curLine.equals("Completed Tasks")) {
                toDoTasks.add(curLine);
                curLine = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // return the complete ArrayList
        return toDoTasks;
    }

    public static ArrayList<String> readCompleteTasks(String path) {
        // Create an array list to hold the completed values (and garbage)
        ArrayList<String> completedTasks = new ArrayList<>();
        ArrayList<String> garbage = new ArrayList<>();

        try {
            // Use a buffered reader to read through the file
            // storing all list items under "To-Do" as garbage
            BufferedReader br = new BufferedReader(new FileReader(path));
            String curLine = br.readLine();
            while(!curLine.equals("Completed Tasks")) {
                garbage.add(curLine);
                curLine = br.readLine();
            }
            // Store "Completed Tasks" as garbage
            garbage.add(curLine);
            // Read through all of the Strings under the "Completed Tasks"
            // header and store inside of the ArrayList
            curLine = br.readLine();
            while (curLine != null) {
                completedTasks.add(curLine);
                curLine = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // return the completed ArrayList of completed items
        return completedTasks;
    }
}
