package fallingpuzzle.controller;

import java.io.IOException;

import fallingpuzzle.model.Griglia;
import fallingpuzzle.view.FPGraphics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FPMainController {
	
	 @FXML
	 private AnchorPane home;
	
	private Stage stage;
	private Scene scene;
	
	public void goToPlay(ActionEvent event) throws IOException {
		Griglia g=new Griglia();
		FPGraphics graphics=new FPGraphics(g);
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(graphics);
		stage.setScene(scene);
		stage.show();
		graphics.matrix();
	}
	 @FXML
	    void exitGame(ActionEvent event) {
		 	System.exit(0);
	    }
	
	
}
