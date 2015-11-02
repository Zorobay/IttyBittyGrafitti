package tools;

import javafx.scene.shape.StrokeLineCap;

public class Brush extends Tool {
	private StrokeLineCap lineCap;
	
	public Brush(StrokeLineCap lc) {
		lineCap = lc;
	}
	
	public StrokeLineCap getLineCap(){
		return lineCap;
	}
}
