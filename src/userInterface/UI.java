package userInterface;

import canvas.IBGCanvas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tools.Toolbar;

public class UI extends Application {

	private IBGCanvas canvas = new IBGCanvas();
	private ColorPicker colorPicker;
	
	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Itty Bitty Grafitty");

		// set up grid pane
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(25, 25, 25, 25));

		// set up canvas to draw on
		pane.add(canvas, 0, 1);
		canvas.setHeight(500);
		canvas.setWidth(600);
		canvas.getGraphicsContext2D().setFill(Color.WHITE);
		canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Set up brush buttons
		Button roundBrushButton = new Button("\u25CF");
		Button squareBrushButton = new Button("\u25A0");
		roundBrushButton.setOnMouseClicked(roundBrushButtonClicked);
		squareBrushButton.setOnMouseClicked(squareBrushButtonClicked);
		
		//Set up the colorpicker
		colorPicker = new ColorPicker();
		colorPicker.setOnAction(colorPickerClicked);

		HBox hbox = new HBox();
		hbox.getChildren().addAll(roundBrushButton, squareBrushButton, colorPicker);
		pane.add(hbox, 0, 0);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Event handler for round brush button. When clicked, select the round
	// brush as active tool
	private final EventHandler<MouseEvent> roundBrushButtonClicked = event -> {
		Toolbar.setActiveTool(0);
	};

	// Event handler for square brush button. When clicked, select the square
	// brush as active tool
	private final EventHandler<MouseEvent> squareBrushButtonClicked = event -> {
		Toolbar.setActiveTool(1);
	};
	public void handle(Event t){
		canvas.setForegroundColor(colorPicker.getValue());
	}
	// Handle colorpicker events
	private final EventHandler<ActionEvent> colorPickerClicked = event ->{
		canvas.setForegroundColor(colorPicker.getValue());
	};
}
