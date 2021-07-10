package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class SaveList {
    private int counter = 1;

    public void saveFile(BorderPane mainPane, FileChooser fileChooser) {
        Window window = mainPane.getScene().getWindow();
        fileChooser.setTitle("Save To-Do List");
        fileChooser.setInitialFileName("todolist" + counter);
        counter++;
        fileChooser.getExtensionFilters().addAll
                (new FileChooser.ExtensionFilter("jar file", ".jar"));
        try {
            File file = fileChooser.showSaveDialog(window);
            fileChooser.setInitialDirectory(file.getParentFile());
            //TODO save contents of the application somehow
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
