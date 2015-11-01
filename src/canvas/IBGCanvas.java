package canvas;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

//This class will be used to define our own customized canvas.
//TODO Come up with a better name
public class IBGCanvas extends Canvas{
	
	private double mouseX;
	private double mouseY;
	
	private final EventHandler<MouseEvent> mouseMovedOnCanvas = mouseEvent -> {
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
		System.out.println("Mouse X: " + mouseX + "\nMouse Y: " + mouseY);
	};
	
	//Paints when dragging
	private final EventHandler<MouseEvent> mouseDraggedCanvas = event -> {
		this.getGraphicsContext2D().setStroke(Color.DARKGREEN);
		this.getGraphicsContext2D().setLineWidth(5);
		this.getGraphicsContext2D().lineTo(event.getX(), event.getY());
		this.getGraphicsContext2D().stroke();
	};
	
	//Enables the user to start a new stroke. Without this, a line would be
	//produced between the release point of the last stroke and the pressed
	//point of the new stroke
	private final EventHandler<MouseEvent> mousePressedCanvas = event -> {
		this.getGraphicsContext2D().moveTo(event.getX(), event.getY());
	};
	
	public IBGCanvas(){
		this.setOnMouseMoved(mouseMovedOnCanvas);
		this.setOnMouseDragged(mouseDraggedCanvas);
		this.setOnMousePressed(mousePressedCanvas);
		}
	
	public IBGCanvas(double w, double h){
		super(w,h);
		this.setOnMouseMoved(mouseMovedOnCanvas);
		this.setOnMouseDragged(mouseDraggedCanvas);
	}
	
	public double getMouseX(){
		return mouseX;
	}
	
	public double getMouseY(){
		return mouseY;
	}
}
