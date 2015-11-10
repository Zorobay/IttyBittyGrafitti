package tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javafx.scene.canvas.Canvas;

public class SaveTool extends Tool{
	public static void saveCanvas(Canvas canvas, String path){
		int width = (int)canvas.getWidth();
		int height = (int)canvas.getHeight();
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
	}
}
