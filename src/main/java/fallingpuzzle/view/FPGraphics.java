package fallingpuzzle.view;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class FPGraphics extends StackPane{
	private Canvas canvas;	
	private Image[] images;
	private int direction;
	
	public FPGraphics(){
		canvas = new Canvas();
		images = new Image[4];		
		getChildren().add(canvas);
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}
	
}
