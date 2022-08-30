package fallingpuzzle.controller;


import fallingpuzzle.view.FPGraphics;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class FPGameController  {
	private FPGraphics graphics;
	public FPGameController(FPGraphics graphics) {
		this.graphics=graphics;
		controller();
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
				System.out.println("WE");
			}
		});

	}
	
}

