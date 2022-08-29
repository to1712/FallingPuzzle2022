package fallingpuzzle.controller;


import fallingpuzzle.view.FPGraphics;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FPGameController  {
	private FPGraphics graphics;
	public FPGameController(FPGraphics graphics) {
		this.graphics=graphics;
		controller();
	}
	
	public void controller() {
		graphics.pausaButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("WE");
			}
			});


	}
	
}

