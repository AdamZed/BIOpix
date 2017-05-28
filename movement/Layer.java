package movement;

/**
 * @version 1.0.1
 */

import javafx.scene.Node;

public class Layer
{
	Layer next,prev;
	int type;
	int layerID;
	
	String name = "";
	boolean blank = true;
	
	Layer(int type)
	{
		this.type = type;
		if(type == 1)
			name = "Draw";
		else if (type == 2)
			name = "Line";
		else if (type == 3)
			name = "Angle";
	}
	
	// Overridden by subclasses
	public void enable(){}
	public void disable(){}
	public void redraw(){}
	public Node getNode(){
		return null;
	}
	
}