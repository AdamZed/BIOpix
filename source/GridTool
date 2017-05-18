package movement;

/**
 * @version 1.0
 */

import javafx.scene.canvas.*;

public class GridTool {

	static boolean locked = false;
	double lineSpace = 40;
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
		for(int i = 0; i*lineSpace < canvas.getWidth(); i++)
			gc.strokeLine(i*lineSpace, 0, i*lineSpace, canvas.getHeight());
		for(int i = 0; i*lineSpace < canvas.getHeight(); i++)
			gc.strokeLine(0, i*lineSpace, canvas.getWidth(), i*lineSpace);
	}
	
	void clear()
	{
		if (!locked)
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
  
}
