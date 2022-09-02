package fallingpuzzle.view;





import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class FPGraphics extends StackPane{
	

    @FXML
    private Button exitButton;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane pausaPane;

	
	
	private final int DIM=50;
	public Canvas canvas;	
	private Griglia griglia=null;
	private Image img = new Image(getClass().getResourceAsStream("/images/FallingBackGround.png"));
	private Image frameImg = new Image(getClass().getResourceAsStream("/images/Frame.png"));
	private Image pausaButtonFrame = new Image(getClass().getResourceAsStream("/images/pausaButton.png"));
	private Image gameFrame = new Image(getClass().getResourceAsStream("/images/gameFrame.png"));
	private ImageView pausaFrame = new ImageView(pausaButtonFrame);
	private ImageView Frame = new ImageView();
	private ImageView Frame2 = new ImageView();
	public Button pausaButton;
	private AnchorPane pane=null;
	
	
	public FPGraphics(Griglia griglia){
		super();
		//this.griglia=griglia;
		pane=new AnchorPane();
		getChildren().add(pane);
		canvas = new Canvas();
		pane.getChildren().add(canvas);
		pane.setPrefHeight(900);
		pane.setPrefWidth(700);
		//pane.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, null, null)));
		pane.setBackground(new Background(new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		//canvas.widthProperty().bind(this.widthProperty());
		//canvas.heightProperty().bind(this.heightProperty());
		/*
		 * settaggi del canvas
		 * */
		
		
		
		canvas.setWidth(500);
		canvas.setHeight(700);
		canvas.setLayoutX(150);
		canvas.setLayoutY(200);
		
		/*
		 * settage della cornice che circonda
		 * la matrice sulla quale si svolge il gioco
		 * 
		 * */
		
		Frame2.setImage(gameFrame);
		Frame2.setFitWidth(700);
		Frame2.setFitHeight(900);		
		
		
		Frame.setImage(frameImg);
		Frame.setFitWidth(570);
		Frame.setFitHeight(770);
		Frame.setLayoutX(60);
		Frame.setLayoutY(115);
		pane.getChildren().add(Frame);
		pane.getChildren().add(Frame2);
		
		pausaFrame.setFitHeight(65);
		pausaFrame.setFitWidth(65);
		pausaButton = new Button();
		
		/*pausaFrame.fitWidthProperty().bind(pausaButton.widthProperty());
		pausaFrame.fitHeightProperty().bind(pausaButton.heightProperty());*/
		//pausaFrame.setPreserveRatio(true);
		//pausaButton.setPrefSize(10, 10);
		pausaButton.setPrefHeight(65);
		pausaButton.setPrefWidth(65);
		pausaButton.setGraphic(pausaFrame);
		pausaButton.setBackground(null);
		pausaButton.setTranslateX(575);
		pausaButton.setTranslateY(20);
		
		pane.getChildren().add(pausaButton);
		pane.getChildren().add(pausaPane);
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
				canvas.getGraphicsContext2D().setFill(Color.TRANSPARENT);
				canvas.getGraphicsContext2D().fillRect(m.getWidth()*DIM, m.getHigh()*DIM, DIM * m.getTipo(), DIM);
			}
			else {
				canvas.getGraphicsContext2D().setFill(Color.BLACK);
				canvas.getGraphicsContext2D().strokeRect(m.getWidth()*DIM, m.getHigh()*DIM, DIM * m.getTipo(), DIM);
			}
		}	
	}
}

	

