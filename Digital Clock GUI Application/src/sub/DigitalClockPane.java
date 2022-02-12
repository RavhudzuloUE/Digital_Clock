package sub;

import java.util.Date;
import java.util.StringTokenizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * @author  Ravhudzulo Unarine Ernest
 * @version DigitalClock
 * 
 * DigitalClockPane is a subclass of StackPane layout inheriting from StackPane
 */
public class DigitalClockPane extends StackPane {
	
	private BorderPane root;
	private VBox       vBox;
	
	private Label timeOfTheYearLabel;
	private Label dateFormatLabel;

	/**
	 * Default Constructor of the DigitalClockPane class
	 */
	public DigitalClockPane() {
		
		setGUI(); // Invoke setGUI method

		// Create an animation for a running Digital Clock
		Timeline animationTime = new Timeline(new KeyFrame(Duration.millis(1000), e ->{
			
			generateCurrentDate(); // Invoke generateCurrentDate method
			
		}));
		
		animationTime.setCycleCount(Timeline.INDEFINITE); //set cycle count indefinite so that the clock can be displayed indefinitely
		animationTime.play(); // Start animation for time and date to be shown
	}
	
	/**
	 *  generateCurrentDate method update the Time and Date that was previously displayed to the user when invoked
	 *  So the current time can be shown 
	 */
	private void generateCurrentDate() {
		
		// Instance of the Date
		Date date = new Date();
		
		String storeDate = date.toString();
		
		StringTokenizer token = new StringTokenizer(storeDate);
		
		if(token.countTokens() == 6) {
			
			String dayOfTheWeek   = token.nextToken();
			String monthOfTheYear = token.nextToken();
			String dayOfTheMonth  = token.nextToken();
			String timeOfTheYear  = token.nextToken();
			String timeZoneUsed   = token.nextToken();
			String currentYear    = token.nextToken();
			
			String dd_mmm_yyyy_day = dayOfTheMonth + " " + monthOfTheYear + " " + currentYear + " " + dayOfTheWeek;
			
			timeOfTheYearLabel.setText(timeOfTheYear + " " +timeZoneUsed);
            dateFormatLabel.setText(dd_mmm_yyyy_day);
			
		}
		
	}
	/**
	 * Set the GUI for how the Digital Clock is supposed to appeal to the user
	 */
	private void setGUI() {
		
		root = new BorderPane();
		root.setStyle("-fx-background-color: BLACK");  // Setting the background  to be black
		
		vBox = new VBox(10);  
		vBox.setAlignment(Pos.CENTER);  // Put the VBox added Children in the Centre
		
		timeOfTheYearLabel   = new Label();  
		dateFormatLabel      = new Label();         
		
		// Set the Font, Colour and Alignment for dateFormatLabel Text
		dateFormatLabel.setFont(Font.font("SansSerif", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 35));
		dateFormatLabel.setTextFill(Color.WHITE);
		dateFormatLabel.setTextAlignment(TextAlignment.CENTER);
		
		// Set the Font and Colour for timeOfTheYearLabel Text
		timeOfTheYearLabel.setFont(Font.font("SansSerif", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 35));
		timeOfTheYearLabel.setTextFill(Color.WHITE);
		
		vBox.getChildren().add(timeOfTheYearLabel);
		vBox.getChildren().add(dateFormatLabel);
		
		root.setCenter(vBox);
		
		getChildren().add(root);  // Add the Children to the StackPane Layout
		
	}

}
