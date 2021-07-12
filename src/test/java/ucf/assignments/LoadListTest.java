/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Literally the only methods outside of NewTask that I can test
// against the program, yikes

class LoadListTest {

    @Test
    void readToDoTasks_return_an_array_list_of_to_do_tasks_from_a_txt_file() {
        // given a file
        // create an ArrayList and populate it how the file would
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("2021-07-24 |  Take a phat shit");
        expectedList.add("2021-07-10 |  Cry over your bad grades");
        expectedList.add("2021-07-30 |  Take your biannual shower");

        // assert that the array list produced by readToDoTasks is the same
        // as the expected list
        // Dear grader, you might need to update the pathname for this to work
        assertEquals(expectedList, LoadList.readToDoTasks
                ("C:\\Users\\G333o\\IdeaProjects\\untitled\\fernandez-cop3330-assignment4part2" +
                        "\\src\\test\\resources\\readFileTest.txt"));
    }

    @Test
    void readCompleteTasks_return_an_array_list_of_completed_tasks_from_a_txt_file() {
        // given a file
        // create an ArrayList and populate it how the file would
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("2021-06-14 |  Cheese the bed");
        expectedList.add("2021-06-16 |  Hopefully be finished with Dr. Hollander's course");
        expectedList.add("2021-07-10 |  Annual break from sobbing uncontrollably");

        // assert that the array list produced by readCompleteTasks is the same
        // as the expected list
        // Dear grader, you might need to update the pathname for this to work
        assertEquals(expectedList, LoadList.readCompleteTasks
                ("C:\\Users\\G333o\\IdeaProjects\\untitled\\fernandez-cop3330-assignment4part2" +
                        "\\src\\test\\resources\\readFileTest.txt"));
    }
}