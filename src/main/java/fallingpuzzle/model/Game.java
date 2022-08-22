package fallingpuzzle.model;


import fallingpuzzle.Settings;
import fallingpuzzle.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Game extends Controller {
	
	@FXML
		private Canvas matrixCanvas;
		private Canvas matrix;
		
		
	  
	private Block[][] blocks=new Block[Settings.CELL_SIZE_X][Settings.CELL_SIZE_Y];
	public Game() {
		matrix=new Canvas();
		matrix.getGraphicsContext2D().setFill(Color.GREEN);
		for(int i=0; i<blocks.length;i++) {
			for(int j=0; j<blocks[i].length;j++) {
				blocks[i][j]=new Block(Block.EMPTY);
			}
		}
	}
	@FXML
	public void draw() {
		System.out.println("Sono dentro mammata");
		matrix.getGraphicsContext2D().clearRect(0, 0, matrix.getWidth(), matrix.getHeight());
		matrix.getGraphicsContext2D().setFill(Color.GREEN);
		for(int i=0; i<blocks.length; i++) {
			for(int j=0; j<blocks[i].length; j++) {
				matrix.getGraphicsContext2D().setFill(Color.GREEN);
			}
		}
	}
}
