package tools;

import javafx.scene.shape.StrokeLineCap;
import tools.Brush;

public class Toolbar {
	
	private static final Tool[] TOOLS = {new Brush(StrokeLineCap.ROUND), new Brush(StrokeLineCap.SQUARE)};
	private static Tool activeTool = TOOLS[0];
	
	public static void setActiveTool(int num){
		activeTool = TOOLS[num];
	}
	
	public static Tool getActiveTool(){
		return activeTool;
	}
}
