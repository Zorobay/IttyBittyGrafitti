package userInterface;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Itty Bitty Grafitty");
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setGridLinesVisible(true);
		
		VBox vbox = new VBox();
		Button b = new Button("SEbbe");
		Button b2 = new Button("Hjalmar");
		vbox.getChildren().addAll(b, b2);
		pane.add(vbox, 4, 4);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
