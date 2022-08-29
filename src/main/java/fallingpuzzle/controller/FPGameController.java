package fallingpuzzle.controller;

import java.io.IOException;



import fallingpuzzle.model.Griglia;
import fallingpuzzle.view.FPGraphics;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class FPGameController implements EventHandler<ActionEvent> {
	
	private FPGraphics grafica;
	private Griglia griglia;
	
	
	public FPGameController(FPGraphics grafica,Griglia griglia) {
		this.griglia = griglia;
		this.grafica = grafica;
	}

// @Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		grafica.pausaButton.setOnAction(new EventHandler<ActionEvent>() {
		  
			public void handle(ActionEvent event) {
		        System.out.print("aru q");
		    }
		});
	}
	
	
	
	
	
	
	
    }

