package fallingpuzzle.model;


import fallingpuzzle.Settings;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Game  {
	  @FXML
	    private Canvas matrixCanvas;
	private Block[][] blocks=new Block[Settings.CELL_SIZE_X][Settings.CELL_SIZE_Y];
	
	public Game() {
		matrixCanvas=new Canvas();
		for(int i=0; i<blocks.length;i++) {
			for(int j=0; j<blocks[i].length;j++) {
				blocks[i][j]=new Block(Block.EMPTY);
			}
		}
	}
	public void draw() {
		System.out.println("Sono dentro mammata");
		matrixCanvas.getGraphicsContext2D().clearRect(0, 0, matrixCanvas.getWidth(), matrixCanvas.getHeight());
		matrixCanvas.getGraphicsContext2D().setFill(Color.GREEN);
		for(int i=0; i<blocks.length; i++) {
			for(int j=0; j<blocks[i].length; j++) {
				matrixCanvas.getGraphicsContext2D().setFill(Color.GREEN);
			}
		}
	}
}
