package fallingpuzzle.controller.scene;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
import fallingpuzzle.FPapplication;
import fallingpuzzle.controller.Controller;
import fallingpuzzle.model.Game;
import javafx.event.ActionEvent;
import javafx.scene.Scene;  
public class FPMainMenuController extends Controller {

	//Stage stage;
	
	private static Scene scene;
	@FXML
	private Button exitButton;
    @FXML
    private Button playButton;
    @FXML
    private AnchorPane home;

    @FXML
    void play(ActionEvent event) {
    	Game game=new Game();
		game.draw();
    	FPapplication.setScene( FPPlayController.getScene() );
    }	
    @FXML
    void Exit(ActionEvent event) {
    	//stage= (Stage) home.getScene().getWindow();
    	//System.out.println("Exit complete");
    	//stage.close();
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Exit");
    	alert.setHeaderText("Stai per uscire dal gioco");
    	//alert.setContentText("");
    	if(alert.showAndWait().get()==ButtonType.OK) {
    		System.exit(0);
    	}
    	
    }
    
	  public static Scene getScene() {
	    	scene = getScene("/View/FPHome.fxml");
	    return scene;
		}
}	
	
	

	  
	 