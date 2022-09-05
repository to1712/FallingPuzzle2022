package fallingpuzzle.view;



import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

public class FPGameOver extends StackPane {
	
	private Image img ;
	
	public FPGameOver() {
		this.setPrefHeight(900);
		this.setPrefWidth(700);
		img = new Image("/images/FallingBackGround.png");
		this.setBackground(new Background(new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	}
}
