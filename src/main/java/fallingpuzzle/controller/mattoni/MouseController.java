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

public class MouseController     {

	Color c=new Color(0, 0, 1, 1.0);
	private final int DIM=50;
	private Griglia griglia=null;
	private FPGraphics graphics;
	private FPGame game;
	private int x,y=0;
	
	public MouseController(Griglia griglia, FPGraphics graphics,FPGame game) {
		this.griglia=griglia;
		this.graphics=graphics;
		this.game=game;
		selezionaMattone();
	}
	
	
	public void selezionaMattone() {
		graphics.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				//x=((int) e.getX()/50)%12;
				//y=((int) e.getY()/50)%12;
				game.mouseRilasciato();
			}
		});
		graphics.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent e) {
				x=((int) e.getX()/50)%12;
				y=((int) e.getY()/50)%12;
			}
		});
		
		graphics.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent e) {
					int w=((int) e.getX()/50)%12;
					System.out.println(x+" "+y);
					if(w>x) {
						System.out.println("muovo a destra");
						game.muovi(x, y, true);
					}
					if(w<x) {
						System.out.println("muovo a sinistra");
						game.muovi(x, y, false);
					}
			}
			
		});
	}
}




