package fallingpuzzle.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class FPGraphics extends StackPane{
	private Canvas canvas;	
	//private Image[] images;
	//private int direction;
	
	public FPGraphics(){
		canvas = new Canvas();
		//images = new Image[4];		
		getChildren().add(canvas);
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}
	
	public void matrix() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.getGraphicsContext2D().setFill(Color.YELLOW);
	}
}
