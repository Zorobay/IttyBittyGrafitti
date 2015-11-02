package tools.brush;

import javafx.scene.shape.StrokeLineCap;

public class SquareBrush extends Brush {
	private final static StrokeLineCap lineCap = StrokeLineCap.SQUARE;
	
	public SquareBrush() {
		super(lineCap);
		
	}
	
}
