package fallingpuzzle.controller;

import java.io.IOException;

import fallingpuzzle.model.FPGame;
import fallingpuzzle.model.Griglia;
import fallingpuzzle.view.FPGraphics;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FPMainController extends Application {
	
	 @FXML
	 private AnchorPane home;
	private Griglia griglia;
	private Stage stage;
	private Scene scene;
	
	public void goToPlay(ActionEvent event) throws IOException {
		//Griglia griglia=new Griglia();
		griglia = new Griglia();
		FPGraphics graphics=new FPGraphics(griglia);
		FPGame game=new FPGame(griglia,graphics);
		FPGameController fpc = new FPGameController(graphics,griglia);
	
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(graphics);
		stage.setScene(scene);
		stage.show();
		
	}
	 @FXML
	    void exitGame(ActionEvent event) {
		 	System.exit(0);
	    }
	 
	 public Griglia getGriglia() {
		 return griglia;
	 }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
