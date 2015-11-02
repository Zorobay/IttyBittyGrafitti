package canvas;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import tools.Tool;
import tools.Toolbar;
import tools.brush.Brush;

//This class will be used to define our own customized canvas.
//TODO Come up with a better name
public class IBGCanvas extends Canvas {

	private double mouseX;
	private double mouseY;

	private final EventHandler<MouseEvent> mouseMovedOnCanvas = mouseEvent -> {
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
		System.out.println("Mouse X: " + mouseX + "\nMouse Y: " + mouseY);
	};

	// Paints when dragging
	private final EventHandler<MouseEvent> mouseDraggedCanvas = event -> {
		this.getGraphicsContext2D().setStroke(Color.DARKGREEN);
		this.getGraphicsContext2D().setLineWidth(5);

		// TODO THIS IS PROBABLY NOT A SUSTAINABLE SOLUTION!!
		Tool activeTool = Toolbar.getActiveTool();
		if (activeTool instanceof Brush) {
			this.getGraphicsContext2D().setLineCap(((Brush) activeTool).getLineCap());
		}
		this.getGraphicsContext2D().lineTo(event.getX(), event.getY());
		this.getGraphicsContext2D().stroke();
	};

	// Enables the user to start a new stroke. Without this, a line would be
	// produced between the release point of the last stroke and the pressed
	// point of the new stroke
	private final EventHandler<MouseEvent> mousePressedCanvas = event -> {
		this.getGraphicsContext2D().setStroke(Color.DARKGREEN);
		this.getGraphicsContext2D().setLineWidth(5);
		
		// TODO THIS IS PROBABLY NOT A SUSTAINABLE SOLUTION!!
		Tool activeTool = Toolbar.getActiveTool();
		if (activeTool instanceof Brush) {
			this.getGraphicsContext2D().setLineCap(((Brush) activeTool).getLineCap());
		}

		this.getGraphicsContext2D().beginPath();
		this.getGraphicsContext2D().lineTo(event.getX(), event.getY());
		this.getGraphicsContext2D().stroke();
	};

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

	public double getMouseX() {
		return mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}
}
