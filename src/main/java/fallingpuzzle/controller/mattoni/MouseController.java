package fallingpuzzle.controller.mattoni;


import fallingpuzzle.Settings;
import fallingpuzzle.model.FPGame;
import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;
import fallingpuzzle.view.FPGraphics;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseController     {

	Color c=new Color(0, 0, 1, 1.0);
	private Griglia griglia=null;
	private FPGraphics graphics;
	private FPGame game;
	private int x,y,temp=0;
	private Mattoni mattoneSelezionato;
	
	public MouseController(Griglia griglia, FPGraphics graphics,FPGame game) {
		this.griglia=griglia;
		this.graphics=graphics;
		this.game=game;
		selezionaMattone();
	}
	
	
	public void selezionaMattone() {
		graphics.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent e) {
				x=((int) e.getX()/Settings.MATTONI_SIZE)%12;
				y=((int) e.getY()/Settings.MATTONI_SIZE)%12;
				temp=x;
				mattoneSelezionato=griglia.getMattoni()[x][y];
				if(mattoneSelezionato!=null)
					mattoneSelezionato.setSelezionato(true);
			}
		});
		
		graphics.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent e) {
					int w=((int) e.getX()/Settings.MATTONI_SIZE)%12;
					if(w>x && x<8 && (w>0 && w<8)) {
						//System.out.println("muovo a destra");
						game.muovi(x, y, true);
						x+=1;
					}
					if(w<x && x>0 && x<8) {
						//System.out.println("muovo a sinistra");
						game.muovi(x, y, false);
						x-=1;
					}
			}
			
		});
		graphics.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				System.out.println("Rilascio");
				if(mattoneSelezionato!=null)
					mattoneSelezionato.setSelezionato(false);
				if(temp!=x)
					game.mouseRilasciato();
					
			}
		});
	}
}




