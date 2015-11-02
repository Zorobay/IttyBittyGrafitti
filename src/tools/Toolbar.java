package tools;

import tools.brush.RoundBrush;
import tools.brush.SquareBrush;

public class Toolbar {
	
	private static final Tool[] TOOLS = {new RoundBrush(), new SquareBrush()};
	private static Tool activeTool = TOOLS[0];
	
	public static void setActiveTool(int num){
		activeTool = TOOLS[num];
	}
	
	public static Tool getActiveTool(){
		return activeTool;
	}
}
