package fallingpuzzle.model;

import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

import fallingpuzzle.view.FPGraphics;
import javafx.application.Platform;

public class FPGame {

	private Timer caduta;
	private TimerTask task;
	private FPGraphics graphics=null;
	private int punti=0;
	private Griglia griglia=null;
	private int cont=0;
	
	public FPGame(final Griglia g,final FPGraphics graphics) {
		this.graphics=graphics;
		griglia=g;
		Timer cades=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if(cont==0) {
							graphics.matrix();
							g.caduta();
						}
						else {
							graphics.matrix();
							g.caduta();
							setGravity();
						}
						cont++;
					}
				});
			}
		};
		cades.schedule(task,0,500);
	}
	
	
	private void setGravity() {
		griglia.deveCadere(true);
		while(griglia.staCadendo()) {
			while(griglia.staCadendo()) {
				griglia.caduta();
				//graphics.matrix();
			}
			int p=griglia.rigaPiena();
			if(p!=0) {
				punti+=p;
				this.griglia.deveCadere(true);
			}
			//graphics.matrix();
		}
		this.griglia.resettaMoltiplicatore();
	}

}
