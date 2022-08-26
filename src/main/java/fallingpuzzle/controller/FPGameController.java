package fallingpuzzle.controller;

import java.io.IOException;

import fallingpuzzle.model.Griglia;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FPGameController {
	private Griglia g;
	private static FPGameController instance=null;
	
	
	public FPGameController() {
		g=new Griglia();
		g.caduta();
	}
}
