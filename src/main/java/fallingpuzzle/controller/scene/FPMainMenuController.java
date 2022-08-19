package fallingpuzzle.controller.scene;


import fallingpuzzle.controller.Controller;
import javafx.scene.Scene;
public class FPMainMenuController extends Controller{
	
	  private static Scene scene;
	
	  public static Scene getScene() {
	    	scene = getScene("/View/FPHome.fxml");
	    	return scene;
		}
}
