package tools.brush;

import javafx.scene.shape.StrokeLineCap;
import tools.Tool;

public class Brush extends Tool {
	private StrokeLineCap lineCap;
	
	public Brush(StrokeLineCap lc) {
		lineCap = lc;
	}
	
	public StrokeLineCap getLineCap(){
		return lineCap;
	}

}
