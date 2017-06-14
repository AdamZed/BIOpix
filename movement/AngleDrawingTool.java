package movement;

/**
 * @version 2.4
 */

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AngleDrawingTool extends Layer{

	private Pane root;
	private Line[] lines = { new Line(), new Line() };
	private Circle[] circles = { new Circle(), new Circle(), new Circle() };
	private Text text = new Text();

	private Color circCol = new Color(1, 1, 0, 0.6);
	private double circRad = 12;

	private Pair current = new Pair();
	private Pair first = new Pair();
	private Pair second = new Pair();
	private Pair third = new Pair();

	AngleCalculator angler = new AngleCalculator();
	private double angle = 0;

	boolean firstLine = true;

	public AngleDrawingTool(int id) {
		
		super(3, id);

		initialize();

	}

	private void initialize() {

		root = new Pane();
		root.setMinWidth(Images.primaryScreenBounds.getWidth());
		root.setMinHeight(Images.primaryScreenBounds.getHeight());
		root.setLayoutX(0 - root.getLayoutBounds().getMinX());
		root.setLayoutY(0 - root.getLayoutBounds().getMinY());

		root.getChildren().add(text);

		for (int i = 0; i < lines.length; i++) {
			lines[i].setStroke(ToolsStage.colour);
			lines[i].setSmooth(true);
			lines[i].setStrokeWidth(ToolsStage.drawSize);
			root.getChildren().add(lines[i]);
		}

		for (int i = 0; i < circles.length; i++) {
			circles[i].setCenterX(-50);
			circles[i].setCenterY(-50);
			circles[i].setFill(circCol);
			circles[i].setRadius(circRad);
			root.getChildren().add(circles[i]);
		}

	}
	
	public void enable() {
		root.setOnMousePressed(mp -> {
			super.blank = false;
			lines[0].setStroke(ToolsStage.colour);
			lines[1].setStroke(ToolsStage.colour);

			if (firstLine) {
				first.setBoth(mp.getSceneX(), mp.getSceneY());
				circles[0].setCenterX(first.getX());
				circles[0].setCenterY(first.getY());
			}

		});

		root.setOnMouseDragged(md -> {

			clear();
			current.setBoth(md.getSceneX(), md.getSceneY());
			if (firstLine) {
				lines[0].setStartX(first.getX());
				lines[0].setStartY(first.getY());
				lines[0].setEndX(current.getX());
				lines[0].setEndY(current.getY());

			} else {
				lines[0].setStartX(first.getX());
				lines[0].setStartY(first.getY());
				lines[0].setEndX(second.getX());
				lines[0].setEndY(second.getY());

				lines[1].setStartX(second.getX());
				lines[1].setStartY(second.getY());
				lines[1].setEndX(current.getX());
				lines[1].setEndY(current.getY());
			}
		});

		root.setOnMouseReleased(mr -> {
			if (firstLine) {
				second.setBoth(mr.getSceneX(), mr.getSceneY());
				lines[0].setStartX(first.getX());
				lines[0].setStartY(first.getY());
				lines[0].setEndX(second.getX());
				lines[0].setEndY(second.getY());

				circles[1].setCenterX(second.getX());
				circles[1].setCenterY(second.getY());

				firstLine = false;
			} else {
				third.setBoth(mr.getSceneX(), mr.getSceneY());
				lines[0].setStartX(first.getX());
				lines[0].setStartY(first.getY());
				lines[0].setEndX(second.getX());
				lines[0].setEndY(second.getY());

				lines[1].setStartX(second.getX());
				lines[1].setStartY(second.getY());
				lines[1].setEndX(third.getX());
				lines[1].setEndY(third.getY());

				circles[2].setCenterX(third.getX());
				circles[2].setCenterY(third.getY());

				angle = angler.getAngle(first, third, second);
				setText();
				disable();
			}
		});
	}

	public void disable() {
		root.setOnMousePressed(null);
		root.setOnMouseDragged(null);
		root.setOnMouseReleased(null);
	}
	
	public void redraw()
	{
		for (int i = 0; i < lines.length; i++) {
			lines[i].setStroke(ToolsStage.colour);
			lines[i].setStrokeWidth(ToolsStage.drawSize);
		}

		for (int i = 0; i < circles.length; i++) {
			circles[i].setFill(circCol);
			circles[i].setRadius(circRad);
		}
		
		text.setFill(ToolsStage.colour);
	}

	private void setText() {

		// 4 MAIN DIRECTIONS //
		if (first.getX() > second.getX() && third.getX() > second.getX()) {
			// draw right
			text.setLayoutX(second.getX() - 60);
			if (angle > 100)
				text.setLayoutX(second.getX() - 75);
			text.setLayoutY(second.getY() + 7);
		} else if (first.getX() < second.getX() && third.getX() < second.getX()) {
			// draw left
			text.setLayoutX(second.getX() + 17);
			text.setLayoutY(second.getY() + 7);
		} else if (first.getY() > second.getY() && third.getY() > second.getY()) {
			// draw up
			text.setLayoutX(second.getX() - 20);
			if (angle > 100)
				text.setLayoutX(second.getX() - 40);
			text.setLayoutY(second.getY() - 25);
		} else if (first.getY() < second.getY() && third.getY() < second.getY()) {
			// draw down
			text.setLayoutX(second.getX() - 20);
			if (angle > 100)
				text.setLayoutX(second.getX() - 35);
			text.setLayoutY(second.getY() + 35);
		}

		// DIAGONALS //
		else if (first.getX() < second.getX() && third.getX() > second.getX()) {
			// left to right
			Pair secLeft = new Pair(second.getX() - 5, second.getY());
			Pair secRight = new Pair(second.getX() + 5, second.getY());
			
			if (first.getY() > second.getY()) { // bottom to top
				if (angler.getAngle(first, secLeft, second) > angler.getAngle(third, secRight, second)) {
					// draw top left
					text.setLayoutX(second.getX() - 75);
					text.setLayoutY(second.getY() - 15);
				} else {
					// draw bottom right
					text.setLayoutX(second.getX() + 15);
					text.setLayoutY(second.getY() + 15);
				}
			} else { // top to bottom
				if (angler.getAngle(first, secLeft, second) > angler.getAngle(third, secRight, second)) {
					// draw bottom left
					text.setLayoutX(second.getX() - 75);
					text.setLayoutY(second.getY() + 15);
				} else {
					// draw top right
					text.setLayoutX(second.getX() + 15);
					text.setLayoutY(second.getY() - 15);
				}
			}
		} else if (first.getX() > second.getX() && third.getX() < second.getX()) {
			// right to left
			Pair secLeft = new Pair(second.getX() - 5, second.getY());
			Pair secRight = new Pair(second.getX() + 5, second.getY());
			
			if (first.getY() > second.getY()) { // bottom to top
				if(angler.getAngle(first, secRight, second) > angler.getAngle(third, secLeft, second)) {
					// draw top right
					text.setLayoutX(second.getX() + 15);
					text.setLayoutY(second.getY() - 15);
				} else {
					// draw bottom left
					text.setLayoutX(second.getX() - 75);
					text.setLayoutY(second.getY() + 15);
				}
			} else { // top to bottom
				if(angler.getAngle(first, secRight, second) > angler.getAngle(third, secLeft, second)) {
					// draw bottom right
					text.setLayoutX(second.getX() + 15);
					text.setLayoutY(second.getY() + 15);
				} else {
					// draw top left
					text.setLayoutX(second.getX() - 75);
					text.setLayoutY(second.getY() - 15);
				}
			}
		}

		text.setStroke(Color.BLACK);
		text.setStrokeWidth(0.2);
		text.setFill(ToolsStage.colour);
		text.setText(String.valueOf(angle));
		text.setFont(Font.font("Verdana", 20));

	}

	private void clear() {
		lines[0].setStartX(-1);
		lines[0].setStartY(-1);
		lines[0].setEndX(-1);
		lines[0].setEndY(-1);

		lines[1].setStartX(-1);
		lines[1].setStartY(-1);
		lines[1].setEndX(-1);
		lines[1].setEndY(-1);
	}

	void load(Pair first, Pair second, Pair third) {
		this.first = first;
		this.second = second;
		this.third = third;
		lines[0].setStartX(first.getX());
		lines[0].setStartY(first.getY());
		lines[0].setEndX(second.getX());
		lines[0].setEndY(second.getY());

		lines[1].setStartX(second.getX());
		lines[1].setStartY(second.getY());
		lines[1].setEndX(third.getX());
		lines[1].setEndY(third.getY());
		
		angle = angler.getAngle(first, third, second);
		setText();
	}

	public Pane getNode() {
		return root;
	}
	
	public void delete()
	{
		((Pane) root.getParent()).getChildren().remove(root);
	}

}