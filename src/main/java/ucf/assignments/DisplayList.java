/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Gabriel Fernandez
 */

package ucf.assignments;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;

public class DisplayList {
    // Display the entire list
    public void displayAll(SplitPane sp) {
        Node divider = sp.lookup(".split-pane-divider");
        if(divider!=null){
            divider.setStyle("-fx-opacity: 1;");
        }
        // set the SplitPane divider to 0.5
        sp.setDividerPosition(0, 0.5f);
    }

    // Display the completed items
    public void displayComplete(SplitPane sp) {
        Node divider = sp.lookup(".split-pane-divider");
        if(divider!=null){
            divider.setStyle("-fx-background-color: transparent;");
        }
        // set the SplitPane divider to 0
        sp.setDividerPosition(0, 0f);
    }

    // Display the incomplete items
    public void displayIncomplete(SplitPane sp) {
        Node divider = sp.lookup(".split-pane-divider");
        if(divider!=null){
            divider.setStyle("-fx-background-color: transparent;");
        }
        // set the SplitPane divider to 1
        sp.setDividerPosition(0, 1f);
    }
}
