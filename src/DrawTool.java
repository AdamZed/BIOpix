package movement;


/**
 * @version 1.2
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class DrawTool extends Layer {

	GraphicsContext gc;
	Canvas canvas = new Canvas(Images.primaryScreenBounds.getWidth(),Images.primaryScreenBounds.getHeight());
	
	DrawTool(int id)
	{
		super(1, id);
		gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(ToolsStage.drawSize);
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
		gc.setLineWidth(ToolsStage.drawSize);
		gc.setStroke(ToolsStage.colour);
	}
	
	public Canvas getNode()
	{
		return canvas;
	}
	
	public void delete()
	{
		((Pane) canvas.getParent()).getChildren().remove(canvas);
	}
	
}
