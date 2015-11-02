package userInterface;

import canvas.IBGCanvas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tools.Toolbar;

public class UI extends Application {

	private final IBGCanvas canvas = new IBGCanvas();
	private final ColorPicker colorPicker;
	
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

		//Set up slider for brush size
		Slider brushSizeSlider = new Slider(0,100,5);
		brushSizeSlider.setMajorTickUnit(20);
		brushSizeSlider.setMinorTickCount(4);
		brushSizeSlider.setBlockIncrement(5);
		brushSizeSlider.showTickLabelsProperty();
		brushSizeSlider.showTickMarksProperty();
		
		brushSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		        canvas.setBrushSize(newValue.intValue());
		    }
		});
		pane.add(brushSizeSlider, 0, 2);
		
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

	// Handle colorpicker events
	private final EventHandler<ActionEvent> colorPickerClicked = event ->{
		canvas.setForegroundColor(colorPicker.getValue());
	};
}
