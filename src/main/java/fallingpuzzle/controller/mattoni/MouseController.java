package fallingpuzzle.controller.mattoni;

import fallingpuzzle.model.Griglia;
import fallingpuzzle.model.Mattoni;
import fallingpuzzle.view.FPGraphics;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseController   {

	private Griglia griglia;
	private FPGraphics graphics;
	public MouseController(Griglia griglia, FPGraphics graphics) {
		this.griglia=griglia;
		this.graphics=graphics;
		selezionaMattone();
	}
	
	
	public void selezionaMattone() {
		graphics.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				int x=((int) e.getX()/50)%12;
				int y=((int) e.getY()/50)%12;
				//System.out.println(x+" "+y);
				for(Mattoni m: griglia.getMattone() ) {
					if(m.getHigh()==y && m.getWidth()==x) {
						System.out.println(m.getTipo());
					}
					/*if(m.getTipo()==2 && m.getHigh()==y && (m.getWidth()>=x && m.getWidth()<=x)) {
						System.out.println(m.getTipo());
						m.setSelezionato(true);
						graphics.matrix();
					}
					*/
				}
					
			}
		});
	}
}




