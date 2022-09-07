package fallingpuzzle.view;







import fallingpuzzle.controller.FPMainController;

import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class FPGraphics extends StackPane{
	
	private final int DIM=50;
	public FPMainController mainC = new FPMainController();
	public Canvas canvas;	
	private Griglia griglia=null;
	//public FPGame fpg = new FPGame(griglia,this);
	
	private Image img = new Image(getClass().getResourceAsStream("/images/FallingBackGround.png"));
	private Image frameImg = new Image(getClass().getResourceAsStream("/images/Frame.png"));
	private Image pausaButtonFrame = new Image(getClass().getResourceAsStream("/images/pausaButton.png"));
	private Image gameFrame = new Image(getClass().getResourceAsStream("/images/gameFrame.png"));
	private Image pausaMenu = new Image(getClass().getResourceAsStream("/images/pausaMenu_preview_rev_1.png"));
	private Image exitButtonFrame = new Image(getClass().getResourceAsStream("/images/pauseExitButton_preview_rev_1.png"));
	private Image homeButtonFrame = new Image(getClass().getResourceAsStream("/images/pauseHomeButton_preview_rev_1.png"));
    private Image labelImage;
    public Image toggleImage = new Image(getClass().getResourceAsStream("/images/Volume_UP.png"));
	
	
	
	public ImageView toggleIV = new ImageView(toggleImage);
	
	
	private ImageView pm = new ImageView(pausaMenu);
	private ImageView pausaFrame = new ImageView(pausaButtonFrame);
	private ImageView Frame = new ImageView();
	private ImageView Frame2 = new ImageView();
	private ImageView exitFrame = new ImageView(exitButtonFrame);
	private ImageView homeFrame = new ImageView(homeButtonFrame);
	
	
	
	public Button pausaButton;
	public Button exitButton;
	public Button homeButton;
	public Pane pausa;
	public ToggleButton musicButton;
	
	
	public Label point;
	
	

	public AnchorPane pauseBackground ;
	private AnchorPane pane=null;
	
	
	
	public FPGraphics(Griglia griglia){
		super();
		
		this.griglia=griglia;
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
		
		point =  new Label();
		//point.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, null, null)));
		labelImage = new Image("/images/score.png",150,100,false,false);
		point.setBackground(new Background(new BackgroundImage(labelImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		point.setLayoutX(250);
		point.setLayoutY(110);
		point.setPrefHeight(100);
		point.setPrefWidth(150);
		//point.setContentDisplay(ContentDisplay.RIGHT);
		point.setAlignment(Pos.CENTER);
		point.setPadding(new Insets(10));
		point.setStyle("-fx-font-size: 40px; -fx-text-fill: black;");
		// label.setMaxWidth(250);
		point.setWrapText(true);
		point.setFont(new Font("Arial", 30));
		
		pane.getChildren().add(point);
		pane.getChildren().add(pausaButton);
		musicButton = new ToggleButton();
		exitButton = new Button();
		homeButton = new Button();
		pauseBackground = new AnchorPane();
		pausa = new Pane();
		pauseMenu();
		pauseBackground.setVisible(false);
	
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
	

	public void pauseMenu() {
		
		pauseBackground.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
		pauseBackground.setPrefHeight(900);
		pauseBackground.setPrefWidth(700);
		
		
		
		pausa.setBackground(new Background(new BackgroundImage(pausaMenu,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	//	pausa.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
		pausa.setPrefHeight(358);
		pausa.setPrefWidth(324);
		pausa.setLayoutX(180);
		pausa.setLayoutY(280);
		
	
		exitButton.setGraphic(exitFrame);
		exitButton.setBackground(null);
		exitButton.setTranslateX(76);
		exitButton.setTranslateY(180);
		toggleIV.setFitHeight(40);
		toggleIV.setFitWidth(40);
		musicButton.setPrefSize(10, 10);
		musicButton.setGraphic(toggleIV);
		musicButton.setTranslateX(135);
		musicButton.setTranslateY(215);
		musicButton.setBackground(null);
		
		
		homeButton.setGraphic(homeFrame);
		homeButton.setBackground(null);
		homeButton.setTranslateX(84);
		homeButton.setTranslateY(130);
		
		pausa.getChildren().add(musicButton);
		pausa.getChildren().add(homeButton);	
		pausa.getChildren().add(exitButton);
		pauseBackground.getChildren().add(pausa);
		pane.getChildren().add(pauseBackground);
			
	}
	
}

	

