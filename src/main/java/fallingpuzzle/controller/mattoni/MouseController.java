package fallingpuzzle.controller.mattoni;



import fallingpuzzle.controller.FPGameController;
import fallingpuzzle.model.FPGame;
import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;
import fallingpuzzle.view.FPGraphics;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseController   {

	Color c=new Color(0, 0, 1, 1.0);
	private final int DIM=50;
	private Griglia griglia=null;
	private FPGraphics graphics;
	private FPGame game;
	public MouseController(Griglia griglia, FPGraphics graphics,FPGame game) {
		this.griglia=griglia;
		this.graphics=graphics;
		this.game=game;
		selezionaMattone();
	}
	
	
	public void selezionaMattone() {
		graphics.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				int x=((int) e.getX()/50)%12;
				int y=((int) e.getY()/50)%12;
				game.mattoneSelezionato(x, y);
			}
		});
	}
}




