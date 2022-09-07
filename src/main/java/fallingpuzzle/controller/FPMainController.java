package fallingpuzzle.controller;

import java.io.IOException;
import fallingpuzzle.controller.mattoni.MouseController;
import fallingpuzzle.model.FPGame;
import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Music;
import fallingpuzzle.view.FPGameOver;
import fallingpuzzle.view.FPGraphics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FPMainController  {
	
	 @FXML
	 private AnchorPane home;
	private Griglia griglia;
	public Stage stage;
	private Scene scene;
	@FXML
	private Button playButtton;
	public FPMainController() {
		
	}
	
	public void goToPlay(ActionEvent event) throws IOException {
		//Griglia griglia=new Griglia();
		griglia = new Griglia();
		Music music = new Music();
		music.music(true);
		FPGraphics graphics=new FPGraphics(griglia);
		FPGame game=new FPGame(griglia,graphics,music);
		FPGameController controller=new FPGameController(graphics,music,game);
		MouseController mouseController=new MouseController(griglia,graphics,game);
		FPGameOver go = new FPGameOver();
		
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(graphics);
		//scene=new Scene(go);
		stage.setScene(scene);
		stage.show();
		
	}
	 @FXML
	    void exitGame(ActionEvent event) {
		 	System.exit(0);
	    }


	 
	 
		
}
