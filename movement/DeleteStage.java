package movement;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class DeleteStage {

	ToolsStage tStage;
	ListView<String> list = new ListView<>();
	Button deleteButton = new Button();
	StackPane node = new StackPane();
	
	DeleteStage(ToolsStage tStage)
	{
		this.tStage = tStage;
		init(this.tStage);
	}
	
	private void init(ToolsStage tStage)
	{
		node.getChildren().addAll(list,deleteButton);
		list.getStylesheets().add("/movement/darkStyle.css");
		
		StackPane.setAlignment(deleteButton, Pos.BOTTOM_RIGHT);
		deleteButton.setStyle(Images.style);
		deleteButton.setGraphic(Images.del);
		
		deleteButton.setOnMouseEntered(e -> {
			deleteButton.setGraphic(Images.delMO);
		});
		
		deleteButton.setOnMouseExited(e -> {
			deleteButton.setGraphic(Images.del);
		});
		
		deleteButton.setOnMousePressed(e -> {
			deleteButton.setGraphic(Images.delSel);
			int selectedIndex = list.getSelectionModel().getSelectedIndex();
			String selectedName = list.getSelectionModel().getSelectedItem();
			String parsedID = "";
			if (selectedIndex != -1) {
				list.getItems().remove(selectedIndex);
				for(int x = 0;;x++)
				{
					if(selectedName.charAt(x) == ' ')
						break;
					parsedID += selectedName.charAt(x);
				}
				tStage.main.layers.delete(Integer.parseInt(parsedID));
			}
		});
	}
	
	public Node getList()
	{
		return node;
	}
	
	public void removeLast()
	{
		list.getItems().remove(list.getItems().size() - 1);
	}
	
	public void add(String name)
	{
		list.getItems().add(name);
	}
	
}
