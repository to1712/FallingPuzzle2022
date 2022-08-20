package fallingpuzzle.controller.scene;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import fallingpuzzle.FPapplication;
import fallingpuzzle.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Scene;  
public class FPMainMenuController extends Controller {

    @FXML
    private Button playButton;

    @FXML
    void play(ActionEvent event) {
    	
    }	
    public void play() {}
  private static Scene scene;
	
	  public static Scene getScene() {
	    	scene = getScene("/View/FPHome.fxml");
	    return scene;
		}
}	
	
	

	  
	 