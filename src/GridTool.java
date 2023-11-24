package movement;

/**
 * @version 1.1
 */

import javafx.scene.canvas.*;

public class GridTool {

	static boolean locked = false;
	GraphicsContext gc;
	Canvas canvas = new Canvas(Images.primaryScreenBounds.getWidth(),Images.primaryScreenBounds.getHeight());
	
	GridTool()
	{
		gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(1);
	}
	
	void paintGrid()
	{
		gc.setStroke(ToolsStage.colour);
		for(int i = 0; i*ToolsStage.gridSize < canvas.getWidth(); i++)
			gc.strokeLine(i*ToolsStage.gridSize, 0, i*ToolsStage.gridSize, canvas.getHeight());
		for(int i = 0; i*ToolsStage.gridSize < canvas.getHeight(); i++)
			gc.strokeLine(0, i*ToolsStage.gridSize, canvas.getWidth(), i*ToolsStage.gridSize);
	}
	
	void clear()
	{
		if (!locked)
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	void redraw()
	{
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		paintGrid();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}