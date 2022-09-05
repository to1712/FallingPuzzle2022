package fallingpuzzle.view;



import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

public class FPGameOver extends StackPane {
	
	private Image img ;
	private Image rbImg = new Image(getClass().getResourceAsStream("/images/restartButtonGO.png"));;
	private Image hbImg = new Image(getClass().getResourceAsStream("/images/homeButtonGO.png"));;
	
	private ImageView resImg = new ImageView(rbImg);
	private ImageView homImg = new ImageView(hbImg);	
	
	public Button restartButton;
	public Button homeButton;
	
	public FPGameOver() {
		
		this.setPrefHeight(900);
		this.setPrefWidth(700);
		img = new Image("/images/gameOver.png");
		this.setBackground(new Background(new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		
		restartButton = new Button();
		restartButton.setTranslateY(150);
		restartButton.setTranslateX(200);
		restartButton.setGraphic(resImg);
		
		homeButton = new Button();
		homeButton.setTranslateX(200);
		homeButton.setTranslateY(250);
		homeButton.setGraphic(homImg);
		
		this.getChildren().add(restartButton);
		this.getChildren().add(homeButton);
		
	}
}
