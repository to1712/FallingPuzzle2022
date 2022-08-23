package fallingpuzzle.model;

import java.util.Vector;

public class Griglia {
	
	public final int WIDTH=8;
	public final int HEIGHT=12;
	private Integer[][] mattonMatrix;
	private Integer[][] backMatrix;
	private Mattoni [][] mattoni;
	private Vector<Mattoni> mattone;
	private Mattoni selezionato=null;
	
	public Griglia() {
		mattonMatrix= new Integer[WIDTH][HEIGHT];
		backMatrix= new Integer[WIDTH][HEIGHT];
		mattoni=new Mattoni[WIDTH][HEIGHT];
		resetMattonMatrix();
		mattone=new Vector<Mattoni>();
		//updateGriglia();
		
	}
	
	public void setMattoneSelezionato(int x,int y) {
		if(selezionato!=null) {
			selezionato.setSelezionato(false);
		}
		selezionato=mattoni[x][y];
		if(selezionato!=null) {
			selezionato.setSelezionato(true);
		}
	}
	
	private void resetMattonMatrix() {
		for(int i=0; i<HEIGHT; i++  ) {
			for(int j=0; j<WIDTH; j++) {
				mattonMatrix[j][i]=0;
				mattoni[j][i]=null;
			}
		}
	}
	
	private void setBackMatrix() {
		for(int i=0; i<HEIGHT; i++  ) {
			for(int j=0; j<WIDTH; j++) {
				backMatrix[j][i]=mattonMatrix[j][i];
			}
		}
	}
	
	
	
	
	
}
