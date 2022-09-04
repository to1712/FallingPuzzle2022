package fallingpuzzle.controller;


import java.io.IOException;

import fallingpuzzle.FPapplication;
import fallingpuzzle.model.Music;
import fallingpuzzle.view.FPGraphics;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FPGameController  {
	

	private FPGraphics graphics;
	private FPapplication fp;
	private Music music;
	
	public FPGameController(FPGraphics graphics,Music music) {
		this.music=music;
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
				graphics.pauseBackground.setVisible(true);
			}
		});
		graphics.homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Torniamo alla home?");
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				Parent root;
				try {
					
					root = FXMLLoader.load(getClass().getResource("/View/FPHome.fxml"));
					music.music(false);
					Scene home= new Scene(root);
					stage.setScene(home);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		});
		graphics.exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				System.out.println("voglio uscire");
				graphics.pauseBackground.setVisible(false);
			}
		});

	}
	//questo sarebbe il metodo per lo stop e play tramite bottone
	public void musicController() {
		graphics.musicButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (graphics.musicButton.isSelected() == false) {
					Image img = new Image(getClass().getResourceAsStream("/images/Volume_UP.png"));
					ImageView imgV = new ImageView(img);
					imgV.setFitHeight(40);
					imgV.setFitWidth(40);
					graphics.musicButton.setGraphic(imgV);
					music.music(true);
			    } 
			    if (graphics.musicButton.isSelected() == true) {
			    	Image img = new Image(getClass().getResourceAsStream("/images/Volume_Down.png"));
					ImageView imgV = new ImageView(img);
					imgV.setFitHeight(40);
					imgV.setFitWidth(40);
					graphics.musicButton.setGraphic(imgV);
			    	music.music(false);
			    }
			}
		});
	}
	
}

