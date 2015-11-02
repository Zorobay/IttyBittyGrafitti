package tools.brush;

import javafx.scene.shape.StrokeLineCap;

public class RoundBrush extends Brush{
	private final static StrokeLineCap lineCap = StrokeLineCap.ROUND;
	
	public RoundBrush(){
		super(lineCap);
	}
}
