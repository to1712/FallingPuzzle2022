package fallingpuzzle.model;


import java.util.Timer;
import java.util.TimerTask;



import fallingpuzzle.view.FPGraphics;
import javafx.application.Platform;



public class FPGame {

	
	private static FPGame instance = null;
	private Timer caduta;
	private TimerTask task;
	private FPGraphics graphics=null;
	private int punti=0;
	private Griglia griglia=null;
	private int cont=0;
	private boolean rilasciato=false;
	private boolean muove=false;
	private boolean reset=false;
	
	
	

	
	
	public FPGame(final Griglia g,final FPGraphics graphics) {
		this.graphics=graphics;
		griglia=g;
		Timer cades=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						graphics.gameOver();
						if(cont==0) {
							graphics.matrix();
						}
						else {
							graphics.matrix();
							setGravity();
						}
						cont++;
						
					}
				});
			}
		};
		cades.schedule(task,0,500);
	}
	
	public void resetta() {
		if(griglia.dead()==true) {
			System.out.println("WE");
			reset=true;
		}
	}
	
	public void mattoneSelezionato(int x, int y){
        this.griglia.setMattoneSelezionato(x, y);
    }
	
	public void mouseRilasciato() {
		if(muove) {
			griglia.generationRiga();
		}
		//muove=false;
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
	public void muovi(int x,int y,boolean d_s) {
		Mattoni mattoneSelezionato=griglia.getMattoni()[x][y];
		muove=false;
		if(mattoneSelezionato!=null) {
			//Movimento a destra true
			if(d_s==true) {
				
				switch (mattoneSelezionato.getTipo()) {
				case 1:{
					if(mattoneSelezionato.getWidth()<7 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+1][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+1][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						//System.out.println("1");
						muove=true;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 2:{
					if(mattoneSelezionato.getWidth()<6 &&griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+2][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+2][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						muove=true;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 3:{
					if(mattoneSelezionato.getWidth()<5 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+3][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+3][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						muove=true;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 4:{
					if(mattoneSelezionato.getWidth()<4 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+4][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+4][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						muove=true;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				default:
					break;
				}
			}
			else {
				if(mattoneSelezionato.getWidth()>0 ) {
					if(griglia.getMattonMatrix()[mattoneSelezionato.getWidth()-1][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()-1][mattoneSelezionato.getHigh()]==null) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()-1);
						muove=true;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
				}
			}
		}
		
	}
	
	
	

}
