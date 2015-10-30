package userInterface;

import canvas.IBGCanvas;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI extends Application {
	
	private IBGCanvas canvas = new IBGCanvas();

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
		
		//set up test image
		//Image img = new Image()
		// Canvas event
		canvas.getGraphicsContext2D().setFill(Color.BLANCHEDALMOND);
		canvas.setOnMouseDragged(mouseDraggedCanvas);
		
		HBox hbox = new HBox();
		Button b = new Button("Brush");
		hbox.getChildren().addAll(b);
		pane.add(hbox, 0, 0);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//TODO improve paint algorithm
	private final EventHandler<MouseEvent> mouseDraggedCanvas = event -> {
		canvas.getGraphicsContext2D().setFill(Color.CORNFLOWERBLUE);
		canvas.getGraphicsContext2D().fillOval(event.getX(), event.getY(), 5, 5);
	};
}
