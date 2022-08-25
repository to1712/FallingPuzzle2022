package fallingpuzzle.controller;

import java.io.IOException;

import fallingpuzzle.model.Griglia;
import fallingpuzzle.view.FPGraphics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FPMainController {
	
	 @FXML
	 private AnchorPane home;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void goToPlay(ActionEvent event) throws IOException {
		FPGraphics graphics=new FPGraphics(new Griglia());
		//home.resize(30,30);
		//home.setStyle("--fx-background-color: transparent");
		//home.resize(30,30);
		//Parent root= FXMLLoader.load(getClass().getResource("/View/FPGame.fxml"));
		//graphics.matrix();
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
