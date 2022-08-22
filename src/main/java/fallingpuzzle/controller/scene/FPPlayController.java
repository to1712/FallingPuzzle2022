package fallingpuzzle.controller.scene;




import fallingpuzzle.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FPPlayController extends Controller {
	
	   @FXML
	    private GridPane pane;
	   
	private static Scene scene;

	public static Scene getScene() {
	    	scene = getScene("/View/FallingGame.fxml");
	    	return scene;
		}
	public void matrix() {
		pane=new GridPane();
		Rectangle rettangolo=new Rectangle(20,20);
		rettangolo.setFill(Color.BLACK);
		pane.add(rettangolo,10,10);
	}
}