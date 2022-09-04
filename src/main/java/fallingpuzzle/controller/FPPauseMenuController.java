package fallingpuzzle.controller;

import java.io.IOException;

import fallingpuzzle.view.FPGraphics;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FPPauseMenuController {
	
	private FPGraphics gp;
	
	public FPPauseMenuController(FPGraphics gp) {
		this.gp = gp;
		controller();
	}
	
	public void controller() {
		gp.exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

		public void handle(MouseEvent event) {
			System.out.println("voglio uscire");
			gp.exitButton.setVisible(false);
			gp.homeButton.setVisible(false);
			gp.pauseBackground.setVisible(false);
		}
		
	});
	
	
	gp.homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Torniamo alla home?");
			Parent part;
			try {
				part = FXMLLoader.load(getClass().getResource("/View/FPHome.fxml"));
				Stage stage = new Stage();
	        Scene scene = new Scene(part);
	        stage.setScene(scene);
	        stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
            
		}
		
	});
		
		
	
	}
}
