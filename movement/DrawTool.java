package movement;

/**
 * @version 1.1
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawTool extends Layer {

	GraphicsContext gc;
	Canvas canvas = new Canvas(Images.primaryScreenBounds.getWidth(),Images.primaryScreenBounds.getHeight());
	static double drawWid = 2;
	
	DrawTool()
	{
		super(1);
		gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(drawWid);
	}
	
	public void enable()
	{
		gc.setStroke(ToolsStage.colour);
		canvas.setOnMousePressed(e-> {
			super.blank = false;
			gc.beginPath();
			gc.moveTo(e.getSceneX(), e.getSceneY());
			gc.stroke();
		});
		
		canvas.setOnMouseDragged(e-> {
			gc.lineTo(e.getSceneX(), e.getSceneY());
			gc.stroke();
		});
	}
	
	public void disable()
	{
		canvas.setOnMousePressed(null);
		canvas.setOnMouseDragged(null);
	}
	
	public void redraw()
	{
		gc.setLineWidth(drawWid);
		gc.setStroke(ToolsStage.colour);
	}
	
	public Canvas getNode()
	{
		return canvas;
	}
	
}
