/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class NewTaskTest {

    @Test
    void test_getDate() {
        // Create a new NewTask
        NewTask task = new NewTask("", LocalDate.now());
        String expected = "2021-08-16";

        // Use setDate() to set an example date
        task.setDate(LocalDate.of(2021, 8, 16));

        // Use getDate() and assert that they are equal
        String actual = task.getDate().toString();
        assertEquals(expected, actual);
    }

    @Test
    void test_setDate() {
        // Create a new task
        NewTask task = new NewTask("", LocalDate.of(1865, 4, 15));

        // Use setDate() to overwrite existing date
        task.setDate(LocalDate.of(1933, 4, 12));

        // Check that date was updated
        assertEquals("1933-04-12", task.getDate().toString());
    }

    @Test
    void test_getDescription() {
        // Create a new NewTask
        NewTask task = new NewTask("Cry myself to sleep", LocalDate.now());
        String expected = "Drink myself to sleep";

        // Use setDescription() to overwrite existing description
        task.setDescription(expected);

        // Use getDescription() and assert that they are equal
        String actual = task.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void test_setDescription() {
        // Create a new task
        NewTask task = new NewTask("Go to the grocery store", LocalDate.now());

        // Use setDescription() to overwrite existing description
        task.setDescription("Go drown my sorrows in alcohol");

        // Check that the description was updated
        assertEquals("Go drown my sorrows in alcohol", task.getDescription());
    }

    @Test
    void isCompleted() {
        // Create a new task
        NewTask task = new NewTask("", LocalDate.now());

        // Set setCompleted() as true
        task.setCompleted(true);
        boolean actual = task.isCompleted();

        // Check that isCompleted() returns true
        assertTrue(actual);
    }

    @Test
    void setCompleted() {
        // Create a new task
        NewTask task = new NewTask("", LocalDate.now());

        // Set setCompleted() as true (because is initialized as false)
        task.setCompleted(true);

        // Check that setCompleted() returns true
        assertTrue(task.isCompleted());
    }
}