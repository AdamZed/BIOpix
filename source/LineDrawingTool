package movement;

/**
 * @version 2.2
 */

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class LineDrawingTool extends Layer {

	private Pane root;
	private Line line = new Line();

	private double lineWid = 2;

	private Pair current = new Pair();
	private Pair first = new Pair();
	private Pair second = new Pair();
	
	LineDrawingTool() {
		
		super(2);
		initialize();
	}

	private void initialize() {

		root = new Pane();
		root.setMinWidth(Images.primaryScreenBounds.getWidth());
		root.setMinHeight(Images.primaryScreenBounds.getHeight());
		root.setLayoutX(0 - root.getLayoutBounds().getMinX());
		root.setLayoutY(0 - root.getLayoutBounds().getMinY());

		line.setStroke(ToolsStage.colour);
		line.setSmooth(true);
		line.setStrokeWidth(lineWid);
		root.getChildren().add(line);

	}

	public void enable() {
		root.setOnMousePressed(mp -> {
			super.blank = false;
			first.setBoth(mp.getSceneX(), mp.getSceneY());
		});

		root.setOnMouseDragged(md -> {

			line.setStroke(ToolsStage.colour);
			clear();
			current.setBoth(md.getSceneX(), md.getSceneY());
			line.setStartX(first.getX());
			line.setStartY(first.getY());
			line.setEndX(current.getX());
			line.setEndY(current.getY());

		});

		root.setOnMouseReleased(mr -> {
			second.setBoth(mr.getSceneX(), mr.getSceneY());
			line.setStartX(first.getX());
			line.setStartY(first.getY());
			line.setEndX(second.getX());
			line.setEndY(second.getY());

			disable();

		});
	}
	
	public void redraw()
	{
		line.setStroke(ToolsStage.colour);
		line.setStrokeWidth(lineWid);
		
		line.setStartX(first.getX());
		line.setStartY(first.getY());
		line.setEndX(second.getX());
		line.setEndY(second.getY());
	}

	public void disable() {
		root.setOnMousePressed(null);
		root.setOnMouseDragged(null);
		root.setOnMouseReleased(null);
	}

	private void clear() {
		line.setStartX(-1);
		line.setStartY(-1);
		line.setEndX(-1);
		line.setEndY(-1);
	}

	void loadLine(Pair first, Pair second) {
		this.first = first;
		this.second = second;

		line.setStartX(first.getX());
		line.setStartY(first.getY());
		line.setEndX(second.getX());
		line.setEndY(second.getY());

	}

	public Pane getNode() {
		return root;
	}

}
