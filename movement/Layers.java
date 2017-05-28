package movement;

/**
  * @version 1.1.1
  */
  
public class Layers {

	static int maxlayerID = -1;
	Layer head = null, tail = null;
	
	public void newAngle()
	{
		if(head == null)
		{
			head = tail = new AngleDrawingTool();
		} else {
			tail.next = new AngleDrawingTool();
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	public void newLine()
	{
		if(head == null)
		{
			head = tail = new LineDrawingTool();
			tail.layerID = ++maxlayerID;
		} else {
			tail.next = new LineDrawingTool();
			tail.next.prev = tail;
			tail = tail.next;
			tail.layerID = ++maxlayerID;
		}
	}
	
	public void newDraw()
	{
		if(head == null)
		{
			head = tail = new DrawTool();
			tail.layerID = ++maxlayerID;
		} else {
			tail.next = new DrawTool();
			tail.next.prev = tail;
			tail = tail.next;
			tail.layerID = ++maxlayerID;
		}
	}
	
	public void deleteTail()
	{
		if(head == tail)
			tail = head = null;
		else {
			tail.prev.next = null;
			tail = tail.prev;
		}
	}
	
	public void delete(int layerID) {
		Layer current = head;
		while(current.next != null && current.next.layerID != layerID)
			current = current.next;
		if(layerID == current.next.layerID)
		{
			current.next = current.next.next;
			current.next.prev = current;
		} else {
			// not found
		}
	}	
	
}