package canvas;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tools.Brush;
import tools.Tool;
import tools.Toolbar;

//This class will be used to define our own customized canvas.
//TODO Come up with a better name
public class IBGCanvas extends Canvas {

	private double mouseX;
	private double mouseY;
	private final GraphicsContext graphics = this.getGraphicsContext2D();

	private final EventHandler<MouseEvent> mouseMovedOnCanvas = mouseEvent -> {
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
		//System.out.println("Mouse X: " + mouseX + "\nMouse Y: " + mouseY);
	};

	// Paints when dragging
	private final EventHandler<MouseEvent> mouseDraggedCanvas = event -> {
		// TODO THIS IS PROBABLY NOT A SUSTAINABLE SOLUTION!!
		Tool activeTool = Toolbar.getActiveTool();
		if (activeTool instanceof Brush) {
			graphics.setLineCap(((Brush) activeTool).getLineCap());
		}
		graphics.lineTo(event.getX(), event.getY());
		graphics.stroke();
	};

	// Enables the user to start a new stroke. Without this, a line would be
	// produced between the release point of the last stroke and the pressed
	// point of the new stroke
	private final EventHandler<MouseEvent> mousePressedCanvas = event -> {
		
		// TODO THIS IS PROBABLY NOT A SUSTAINABLE SOLUTION!!
		Tool activeTool = Toolbar.getActiveTool();
		if (activeTool instanceof Brush) {
			graphics.setLineCap(((Brush) activeTool).getLineCap());
		}

		graphics.beginPath();
		graphics.lineTo(event.getX(), event.getY());
		graphics.stroke();
	};
	
	//Constructors
	public IBGCanvas() {
		this.setOnMouseMoved(mouseMovedOnCanvas);
		this.setOnMouseDragged(mouseDraggedCanvas);
		this.setOnMousePressed(mousePressedCanvas);
	}

	public IBGCanvas(double w, double h) {
		super(w, h);
		this.setOnMouseMoved(mouseMovedOnCanvas);
		this.setOnMouseDragged(mouseDraggedCanvas);
	}
	
	public void setBrushSize(int size){
		graphics.setLineWidth(size);
	}

	public void setForegroundColor(Color color){
		this.getGraphicsContext2D().setStroke(color);
	}

	public double getMouseX() {
		return mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}
}
