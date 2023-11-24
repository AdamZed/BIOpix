package movement;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;
import javafx.stage.Screen;

public class Images {
	
	static final Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	static final String style = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
	
	static final ImageView upload = new ImageView(new Image("/buttons/upload.png"));
		
	static final ImageView angle = new ImageView(new Image("/buttons/angle.png", 40, 40, true, true));
	static final ImageView angleSel = new ImageView(new Image("/buttons/angleSel.png", 40, 40, true, true));
	static final ImageView angleMO = new ImageView(new Image("/buttons/angleMO.png", 40, 40, true, true));
	    
	static final ImageView line = new ImageView(new Image("/buttons/line.png", 40, 40, true, true));
	static final ImageView lineSel = new ImageView(new Image("/buttons/lineSel.png", 40, 40, true, true));
	static final ImageView lineMO = new ImageView(new Image("/buttons/lineMO.png", 40, 40, true, true));
	
	static final ImageView draw = new ImageView(new Image("/buttons/draw.png", 40, 40, true, true));
	static final ImageView drawSel = new ImageView(new Image("/buttons/drawSel.png", 40, 40, true, true));
	static final ImageView drawMO = new ImageView(new Image("/buttons/drawMO.png", 40, 40, true, true));
	
	static final ImageView grid = new ImageView(new Image("/buttons/grid.png", 40, 40, true, true));
	static final ImageView gridSel = new ImageView(new Image("/buttons/gridSel.png", 40, 40, true, true));
	static final ImageView gridMO = new ImageView(new Image("/buttons/gridMO.png", 40, 40, true, true));
	static final ImageView gridLoc = new ImageView(new Image("/buttons/gridLoc.png", 40, 40, true, true));
	
	static final ImageView drag = new ImageView(new Image("/buttons/drag.png", 40, 40, true, true));
	
}
