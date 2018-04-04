

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class OsloMet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OsloMet extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        // Create a Button or any control item
        Button button1 = createButton("Knapp 1", 100, 100);
        Button button2 = createButton("Knapp 2", 100, 100);
        Button button3 = createButton("Knapp 3", 100, 100);
        Button button4 = createButton("Knapp 4", 100, 100);
        Button button5 = createButton("Knapp 5", 100, 100);
        Button button6 = createButton("Knapp 6", 100, 100);

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(0, 0, 0, 0));
        pane.setMinSize(400, 400);
        pane.setVgap(0);
        pane.setHgap(0);

        // Add the button and label into the pane
        pane.add(button1, 0, 0);
        pane.add(button2, 1, 0);
        pane.add(button3, 0, 1);
        pane.add(button4, 1, 1);
        pane.add(button5, 1, 2);
        pane.add(button6, 2, 0);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
    
    private Button createButton(String label, int width, int height) {
        
        Button b = new Button(label);
        b.setMinWidth(width);
        b.setMinHeight(height);
        return b;
        
    }


}
