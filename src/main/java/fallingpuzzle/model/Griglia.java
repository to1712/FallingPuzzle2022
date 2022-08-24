package fallingpuzzle.model;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Random;
import java.util.Vector;

import javax.print.event.PrintJobAttributeEvent;

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
	public void generationRiga() {
		this.saliRighe();
		int size=0; 
		int maxsize=6;
		Random random=new Random();
		
		while(size<maxsize) {
			int tipo=0;
			int x=random.nextInt(8);
			int y=9;
			int rand=random.nextInt(4);
			if(rand==1)
				tipo=1;
			if(rand==2)
				tipo=2;
			if(rand==3)
				tipo=3;
			if(rand==4)
				tipo=4;
			
			Mattoni m=new Mattoni(tipo, x, y);
			if((x+m.getTipo())-1 <8 &&(m.getTipo()+size)<=maxsize) {
				size+=m.getTipo();
				this.mattone.add(m);
				this.aggiornaGriglia();
			}
		}
	}
	private void saliRighe() {
		for(Mattoni m: this.mattone) {
			m.setWidth(m.getWidth()-1);
		}
		this.aggiornaGriglia();
	}
	public void aggiornaGriglia() {
		resetMattonMatrix();
		for(Mattoni m: this.mattone) {
			for(int i=m.getWidth(); i<m.getHigh()+m.getTipo(); i++) {
				this.mattonMatrix[i][m.getHigh()]=m.getTipo();
				this.mattoni[i][m.getHigh()]=m;
			}
		}
	}
	public Vector<Mattoni> getMattone(){
		return this.mattone;
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
	
	public void stampa() {
		for(int i=0; i<HEIGHT; i++  ) {
			for(int j=0; j<WIDTH; j++) {
				System.out.println(mattonMatrix[j][i]);
			}
		}
	}
	
	
	
	
	
}
