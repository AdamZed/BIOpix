package movement;

/**
 * @version 1.1
 */

import javafx.scene.Node;

public class Layer
{
	Layer next,prev;
	int type;
	int layerID;
	
	String name = "";
	boolean blank = true;
	
	Layer(int type, int id)
	{
		this.type = type;
		this.layerID = id;
		if(type == 1)
			name = layerID + " Draw";
		else if (type == 2)
			name = layerID + " Line";
		else if (type == 3)
			name = layerID + " Angle";
	}
	
	// Overridden by subclasses
	public void enable(){}
	public void disable(){}
	public void redraw(){}
	public Node getNode(){
		return null;
	}
	public void delete(){}
	
}