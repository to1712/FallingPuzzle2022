package fallingpuzzle.controller.scene;


import fallingpuzzle.controller.Controller;
import fallingpuzzle.model.Game;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class FPPlayController extends Controller {
	
	private static Scene scene;

	public static Scene getScene() {
	    	scene = getScene("/View/FallingGame.fxml");
	    	return scene;
		}
	@FXML
	public void initialize() {
		System.out.println("Sono dentro");
	}
}
