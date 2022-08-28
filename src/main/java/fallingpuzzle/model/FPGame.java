package fallingpuzzle.model;

import java.util.Timer;
import java.util.TimerTask;

import fallingpuzzle.view.FPGraphics;
import javafx.application.Platform;

public class FPGame {

	private Timer caduta;
	private TimerTask task;
	
	public FPGame(final Griglia g,final FPGraphics graphics) {
		Timer cades=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					
					public void run() {
						graphics.matrix();
						g.caduta();
					}
				});
				
			}
		};
		cades.schedule(task,0,500);
	}
	

}
