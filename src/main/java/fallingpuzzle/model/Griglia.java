package fallingpuzzle.model;

import java.util.Random;
import java.util.Vector;
import java.util.Objects;




public class Griglia {
	
	public final int WIDTH=8;
	public final int HEIGHT=12;
	private Integer[][] mattonMatrix;
	private Integer[][] backMatrix;
	private Mattoni [][] mattoni;
	private Vector<Mattoni> mattone;
	private Mattoni selezionato=null;
	private boolean cade;  // boolean true se il mattone deve cadere false altrimenti
	
	
	
	//Stampa Il gioco
	public Griglia() {
		mattonMatrix= new Integer[WIDTH][HEIGHT];
		backMatrix= new Integer[WIDTH][HEIGHT];
		mattoni=new Mattoni[WIDTH][HEIGHT];
		resetMattonMatrix();
		mattone=new Vector<Mattoni>();
		aggiornaGriglia();
		int i=0;
		while(i<3) {
			generationRiga();
			i++;
		}
		stampa();
	}
	
	
	
	
	//Genera una nuova riga  e tramite "saliRighe()" sale di una posizione la riga nella matrice
	public void generationRiga() {
		this.saliRighe();
		int size=0; 
		int maxsize=6;
		Random random=new Random();
		
		while(size<maxsize) {
			int tipo=0;
			int x=random.nextInt(8);
			int y=11;
			int rand=random.nextInt(200);
			if(rand>=0 && rand<40) //20%
				tipo=1;
			if(rand>=40 && rand<110) //35%
				tipo=2;
			if(rand>=110 && rand<180) //35%
				tipo=3;
			if(rand>=180 && rand<=200) //10%
				tipo=4;
			
			Mattoni m=new Mattoni(tipo, x, y);
			if((x+m.getTipo())-1 <8 &&(m.getTipo()+size)<=maxsize) {
				if(!this.e_sovrapposto(m.getTipo(), m.getWidth(), m.getHigh())) {
					size+=m.getTipo();
					this.mattone.add(m);
					this.aggiornaGriglia();
				}
			}
		}
	}
	
	private void saliRighe() {
		for(Mattoni m: this.mattone) {
			m.setHigh(m.getHigh()-1);
		}
		this.aggiornaGriglia();
	}
	public void aggiornaGriglia() {
		resetMattonMatrix();
		for(Mattoni m: this.mattone) {
			for(int i=m.getWidth(); i<m.getWidth()+m.getTipo(); i++) {
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
				System.out.print(mattonMatrix[j][i]);
			}
			System.out.print("\n");
		}
	}
	
	private boolean e_sovrapposto(int tipo, int width ,int high) {
		boolean b=false;
		if(high>=12) {
			return b;
		}
		for(int x=width; x<width+tipo;x++) {
			if(mattonMatrix[x][high]!=0) {
				b=true;
			}
		}
		return b;
	}
	
	public void caduta() {
		setBackMatrix();
		for(int i=this.mattone.size()-1; i>=0; i--) {
			Mattoni m=mattone.get(i);
			if((m.getHigh()+1)<10 & !e_sovrapposto(m.getTipo(), m.getWidth(), m.getHigh()+1)) {
				m.setHigh(m.getHigh()+11);
			}
			aggiornaGriglia();
		}
		//if()
	}
	
	public boolean matrixUguali() {
		for(int i=0; i<HEIGHT; i++ ) {
			for(int j=0; j<WIDTH; j++) {
				if(!Object.equals(mattonMatrix[j][i],backMatrix[j][i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
}
