import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sub.DigitalClockPane;

/**
 * Main is a subClass of Application which inherit from it
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Instance of the DigitalClockPane layout, a child of StackPane
		DigitalClockPane pane = new DigitalClockPane();
		
		// Create a Scene for the DigitalClockPane layout
		Scene clockScene = new Scene(pane, 300, 200);
		
		primaryStage.setTitle("DIGITAL CLOCK");  // set the title of stage
		primaryStage.setScene(clockScene);       // set the Scene on the Stage
		primaryStage.show();                     // Display it the Users

	}

	public static void main(String[] args) {
		
		launch(args); // Launch the Application

	}

}
