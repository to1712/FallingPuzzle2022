package fallingpuzzle.view;




import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

public class FPGameOver extends StackPane {
	

	private Image img;
	private Image rbImg;
	private Image hbImg;
	private Image maxScore;
	private Image actualScore;
	
	private ImageView resImg;
	private ImageView homImg;
    private ImageView maxScoreIV;
	private ImageView actualScoreIV;
	
	public Button restartButton;
	public Button homeButtonGO;
	
	public Label actualPunteggio;
	public Label maxPunteggio;
	



	
	public FPGameOver() {
		this.setPrefHeight(900);
		this.setPrefWidth(700);
		img = new Image("/images/gameOver.png");
		this.setBackground(new Background(new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

		rbImg = new Image(getClass().getResourceAsStream("/images/playButtonGO.png"));
		hbImg = new Image(getClass().getResourceAsStream("/images/homeButtonGO.png"));
		
		resImg = new ImageView(rbImg);
		homImg = new ImageView(hbImg);
		
		restartButton = new Button();
		restartButton.setBackground(null);
		resImg.setFitHeight(140);
		resImg.setFitWidth(140);
		restartButton.setTranslateY(120);
		restartButton.setTranslateX(-10);
		restartButton.setGraphic(resImg);
		
		homeButtonGO = new Button();
		homeButtonGO.setBackground(null);
		homImg.setFitHeight(100);
		homImg.setFitWidth(100);
		homeButtonGO.setTranslateX(-10);
		homeButtonGO.setTranslateY(220);
		homeButtonGO.setGraphic(homImg);
		
		actualScore = new Image("/images/actualPunteggio.png");
		actualScoreIV = new ImageView(actualScore);
		actualPunteggio = new Label();
		//actualPunteggio.setBackground(new Background(new BackgroundImage(actualScore,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		actualScoreIV.setFitWidth(250);
		actualScoreIV.setFitHeight(100);
		actualPunteggio.setGraphic(actualScoreIV);
		actualPunteggio.setTranslateX(150);
		actualPunteggio.setTranslateY(150);
		
		maxScore = new Image("/images/scorePiuGrande.png");
		maxScoreIV = new ImageView(maxScore);
		maxPunteggio = new Label();		
		//maxPunteggio.setBackground(new Background(new BackgroundImage(maxScore,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		maxScoreIV.setFitWidth(250);
		maxScoreIV.setFitHeight(100);
		maxPunteggio.setGraphic(maxScoreIV);
		maxPunteggio.setTranslateX(200);
		maxPunteggio.setTranslateY(150);
		/*maxPunteggio.setPrefHeight(100);
		maxPunteggio.setPrefWidth(250);*/
		
		this.getChildren().add(actualPunteggio);
		this.getChildren().add(maxPunteggio);
		this.getChildren().add(restartButton);
		this.getChildren().add(homeButtonGO);
		

	}
	
}
