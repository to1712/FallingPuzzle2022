package fallingpuzzle.controller;


import fallingpuzzle.FPapplication;
import fallingpuzzle.view.FPGraphics;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class FPGameController  {
	

	private FPGraphics graphics;
	private FPapplication fp;
	
	public FPGameController(FPGraphics graphics) {
		this.graphics=graphics;
		controller();
		musicController();
	}
	
	
	
	public void controller() {
		final ScaleTransition scale=new ScaleTransition();
		graphics.pausaButton.setOnMouseMoved(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				scale.setNode(graphics.pausaButton);
				scale.setDuration(Duration.millis(500));
				scale.setCycleCount(2);
				scale.setInterpolator(Interpolator.LINEAR);
				scale.setByX(0.3);
				scale.setByY(0.3);
				scale.setAutoReverse(true);
				scale.play();
			}
			});
		graphics.pausaButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.out.println("sono dentro handle()");
				/*graphics.setPane(pp1);
				System.out.println("Pane aggiunto");*/
				
				graphics.showPauseMenu();
			}
		});

	}
	//questo sarebbe il metodo per lo stop e play tramite bottone
	public void musicController() {
		graphics.musicButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (graphics.musicButton.isSelected() == false) {
                fp.bm.play();
					
			    } 

			    if (graphics.musicButton.isSelected() == true) {

			    	fp.bm.pause();
			    }
			}
		});
	}
	
}

