package fallingpuzzle.view;




import javafx.geometry.Pos;
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
		restartButton.setTranslateY(130);
		restartButton.setTranslateX(0);
		restartButton.setGraphic(resImg);
		
		homeButtonGO = new Button();
		homeButtonGO.setBackground(null);
		homImg.setFitHeight(100);
		homImg.setFitWidth(100);
		homeButtonGO.setTranslateX(0);
		homeButtonGO.setTranslateY(250);
		homeButtonGO.setGraphic(homImg);
		
		actualScore = new Image("/images/actualPunteggio.png",250,110,false,false);
		actualPunteggio = new Label();
		actualPunteggio.setTranslateX(0);
		actualPunteggio.setTranslateY(20);
		actualPunteggio.setBackground(new Background(new BackgroundImage(actualScore,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		actualPunteggio.setPrefHeight(110);
		actualPunteggio.setPrefWidth(250);
		
		maxScore = new Image("/images/scorePiuGrande.png",350,100, false, false);
		
		maxPunteggio = new Label();		
		maxPunteggio.setTranslateX(0);
		maxPunteggio.setTranslateY(-60);
		maxPunteggio.setBackground(new Background(new BackgroundImage(maxScore,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		maxPunteggio.setPrefHeight(100);
		maxPunteggio.setPrefWidth(350);
		
		actualPunteggio.setAlignment(Pos.CENTER);
		maxPunteggio.setAlignment(Pos.CENTER);
		actualPunteggio.setStyle("-fx-font-size: 15px; -fx-text-fill: black; -fx-font-weight: bold;");
		
		maxPunteggio.setStyle("-fx-font-size: 18px; -fx-text-fill: black; -fx-font-weight: bold;");
		
	
		
		this.getChildren().add(actualPunteggio);
		this.getChildren().add(maxPunteggio);
		this.getChildren().add(restartButton);
		this.getChildren().add(homeButtonGO);
		

	}
	
}
