package movement;

/**
  * @version 1.1
  */
  
public class Layers {

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
			head = tail = new DrawTool();
		} else {
			tail.next = new DrawTool();
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	public void newDraw()
	{
		if(head == null)
		{
			head = tail = new LineDrawingTool();
		} else {
			tail.next = new LineDrawingTool();
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
	
	public void delete(int layerNum){}	
	public void moveUp(int layerNum){}
	public void moveDown(int layerNum){}
	
}
