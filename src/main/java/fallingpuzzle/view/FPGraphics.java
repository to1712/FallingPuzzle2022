package fallingpuzzle.view;



import java.io.File;

import javax.imageio.ImageIO;

import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class FPGraphics extends StackPane{
	private final int DIM=50;
	private Canvas canvas;	
	private Griglia griglia=null;
	private Image img = new Image(getClass().getResourceAsStream("/images/FallingBackGround.png"));
	private Image frameImg = new Image(getClass().getResourceAsStream("/images/CornicePlay.png"));
	private ImageView Frame = new ImageView();
	
	public FPGraphics(Griglia griglia){
		AnchorPane pane=new AnchorPane();
		getChildren().add(pane);
		canvas = new Canvas();
		pane.getChildren().add(canvas);
		pane.setPrefHeight(900);
		pane.setPrefWidth(700);
		//pane.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, null, null)));
		pane.setBackground(new Background(new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		//canvas.widthProperty().bind(this.widthProperty());
		//canvas.heightProperty().bind(this.heightProperty());
		
		canvas.setWidth(500);
		canvas.setHeight(700);
		canvas.setLayoutX(150);
		canvas.setLayoutY(200);
		
		
		Frame.setImage(frameImg);
		Frame.setFitWidth(640);
		Frame.setFitHeight(700);
		Frame.setLayoutX(-30);
		Frame.setLayoutY(150);
		pane.getChildren().add(Frame);
		//canvas.setDisable(true);
		this.griglia=griglia;
		
		
	}
	
	public void matrix() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(int i=0; i<this.griglia.WIDTH; i++) {
			for(int j=0; j<this.griglia.HEIGHT; j++) {
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().strokeRect(i*DIM, j*DIM, DIM, DIM);
				//canvas.getGraphicsContext2D().fillRect(i*DIM, j*DIM, DIM, DIM);
			}
		}
		
		for(Mattoni m : this.griglia.getMattone()){
			switch (m.getTipo()) {
			case 1: canvas.getGraphicsContext2D().setFill(Color.INDIANRED);
			break;
			case 2: canvas.getGraphicsContext2D().setFill(Color.DARKORANGE);
			
			break;
			case 3: canvas.getGraphicsContext2D().setFill(Color.DARKCYAN);
			
			break;
			case 4: canvas.getGraphicsContext2D().setFill(Color.FORESTGREEN);
			
			break;
			default:canvas.getGraphicsContext2D().setFill(Color.WHITE);
				break;
			}
			canvas.getGraphicsContext2D().fillRect(m.getWidth() * DIM, m.getHigh() * DIM, DIM * m.getTipo(), DIM);
			
			if(m.eSelezionato()) {
				canvas.getGraphicsContext2D().setFill(Color.YELLOW);
				canvas.getGraphicsContext2D().strokeRect(m.getWidth()*DIM, m.getHigh()*DIM, m.getTipo()*DIM, DIM);
			}
			else {
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().strokeRect(m.getWidth()*DIM, m.getHigh()*DIM, m.getTipo()*DIM, DIM);
			}
		}
		
		
	}
}
