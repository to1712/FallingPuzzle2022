package fallingpuzzle.view;

import fallingpuzzle.model.Griglia;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class FPGraphics extends StackPane{
	private final int DIM=50;
	private Canvas canvas;	
	private Griglia griglia=null;
	
	public FPGraphics(Griglia griglia){
		AnchorPane pane=new AnchorPane();
		getChildren().add(pane);
		canvas = new Canvas();
		pane.getChildren().add(canvas);
		pane.setPrefHeight(900);
		pane.setPrefWidth(700);
		//canvas.widthProperty().bind(this.widthProperty());
		//canvas.heightProperty().bind(this.heightProperty());
		canvas.setWidth(500);
		canvas.setHeight(700);
		canvas.setLayoutX(150);
		canvas.setLayoutY(200);
		//canvas.setDisable(true);
		this.griglia=griglia;
		pane.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, null, null)));
	}
	
	public void matrix() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(int i=0; i<this.griglia.WIDTH; i++) {
			for(int j=0; j<this.griglia.HEIGHT; j++) {
				canvas.getGraphicsContext2D().setFill(Color.YELLOW);
				canvas.getGraphicsContext2D().strokeRect(i*DIM, j*DIM, DIM, DIM);
				canvas.getGraphicsContext2D().fillRect(i*DIM, j*DIM, DIM, DIM);
			}
		}
	}
}
