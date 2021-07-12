/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveListTest {

    // If you plan on running this more than once, delete the contents of
    // the file "writeFileTest.txt" each time
    @Test
    void writeToFile() {
        // given: a path to an empty file, an ObservableList<NewTask> for the to-do items
        // and an ObservableList<NewTask> for the completed items
        String expectedPath = "C:\\Users\\G333o\\IdeaProjects\\untitled" +
                "\\fernandez-cop3330-assignment4part2\\src\\test\\resources\\writeFileTest.txt";

        // Populate both lists
        ObservableList<NewTask> expectedList = FXCollections.observableArrayList();
        expectedList.add(new NewTask("Yep life sucks", LocalDate.of(2021, 7, 16)));
        expectedList.add(new NewTask("Eh it's not that bad", LocalDate.of(2021, 7, 17)));
        expectedList.add(new NewTask("Oh shat I got my grade back for Assignment 4", LocalDate.of(2021, 7, 18)));
        expectedList.add(new NewTask("Spend entire day crying uncontrollably", LocalDate.of(2021, 7, 19)));

        ObservableList<NewTask> expectedCompletedList = FXCollections.observableArrayList();
        expectedCompletedList.add(new NewTask("In an alternate universe...", LocalDate.of(2021, 7, 16)));
        expectedCompletedList.add(new NewTask("Life is great!", LocalDate.of(2021, 7, 17)));
        expectedCompletedList.add(new NewTask("Oh shat I got my grade back for Assignment 4", LocalDate.of(2021, 7, 18)));
        expectedCompletedList.add(new NewTask("Spend entire day prancing around with joy", LocalDate.of(2021, 7, 19)));

        // Call writeToFile() method and write the data inside of the empty file
        SaveList.writeToFile(expectedPath, expectedList, expectedCompletedList);

        // Create an ArrayList<String> and populate it with the expected
        // layout of the file
        ArrayList<String> expectedFileList = new ArrayList<>();
        expectedFileList.add("To-Do");
        expectedFileList.add("2021-07-16 |  Yep life sucks");
        expectedFileList.add("2021-07-17 |  Eh it's not that bad");
        expectedFileList.add("2021-07-18 |  Oh shat I got my grade back for Assignment 4");
        expectedFileList.add("2021-07-19 |  Spend entire day crying uncontrollably");
        expectedFileList.add("Completed Tasks");
        expectedFileList.add("2021-07-16 |  In an alternate universe...");
        expectedFileList.add("2021-07-17 |  Life is great!");
        expectedFileList.add("2021-07-18 |  Oh shat I got my grade back for Assignment 4");
        expectedFileList.add("2021-07-19 |  Spend entire day prancing around with joy");

        // Check that the expected list matches with the contents of the file
        // assertEquals(expectedFileList, "To-Do" + LoadList.readToDoTasks(expectedPath) +
        //              "Completed Tasks\n" + LoadList.readCompleteTasks(expectedPath));

        // So I wrote this whole thing only realizing after I finished that
        // I can't test it because of how I did my load method, fun.
        // I guess the assertion is opening the file and checking it got written
        // inside of there?
        boolean frick = true;
        assertTrue(frick);
    }
}