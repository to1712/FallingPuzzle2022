package fallingpuzzle.controller.scene;


import fallingpuzzle.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class FPPlayController extends Controller {
	
	@FXML
    private ImageView Sfondo;
	private static Scene scene;

	public static Scene getScene() {
	    	scene = getScene("/View/FallingGame.fxml");
	    	return scene;
		}
	//public void initialize(URL url, ResourceBundle rb) {
    //      Image i = new Image(new File("/View/Cornice.gif").toURI().toString());
    //     Sfondo.setImage(i);
   //}
}
