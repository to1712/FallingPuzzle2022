package fallingpuzzle.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FPPlayController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void goToHome(ActionEvent event) throws IOException {
		Parent root= FXMLLoader.load(getClass().getResource("/View/FPMainMenu.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
