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
			head = tail = new AngleDrawingTool(++maxlayerID);
		} else {
			tail.next = new AngleDrawingTool(++maxlayerID);
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	public void newLine()
	{
		if(head == null)
		{
			head = tail = new LineDrawingTool(++maxlayerID);
		} else {
			tail.next = new LineDrawingTool(++maxlayerID);
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	public void newDraw()
	{
		if(head == null)
		{
			head = tail = new DrawTool(++maxlayerID);
		} else {
			tail.next = new DrawTool(++maxlayerID);
			tail.next.prev = tail;
			tail = tail.next;
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
		Layer toDelete = null;
		while(current.next != null && current.next.layerID != layerID) {
			current = current.next;
		}
		if(current.next != null) {
			if(layerID == current.next.layerID) {
				toDelete = current.next;
				current.next.prev = current;
				current.next = current.next.next;	
			} else {
				if (head.layerID == layerID) {
					toDelete = head;
					head = head.next;
					head.prev = null;
				} else {
				}
			}
		} else {
			if (head.layerID == layerID) {
				toDelete = head;
				head = head.next;
			} else {
			}
		}
		
		toDelete.delete();
		
	}
}