package tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;

public class SaveTool extends Tool{
	public static void saveCanvas(Canvas canvas,String name, String path){
		int width = (int)canvas.getWidth();
		int height = (int)canvas.getHeight();
		WritableImage image = new WritableImage(width,height);
		canvas.snapshot(new SnapshotParameters(), image);
		File file = new File(name);
		
		try{
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
