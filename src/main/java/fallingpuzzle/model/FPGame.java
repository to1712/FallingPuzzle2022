package fallingpuzzle.model;


import java.util.Timer;
import java.util.TimerTask;

import fallingpuzzle.controller.FPMainController;
import fallingpuzzle.view.FPGameOver;
import fallingpuzzle.view.FPGraphics;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class FPGame {

	
	public Timer cades;
	public Stage stage;
	private Scene scene;
	private TimerTask task;
	private FPGraphics graphics=null;
	private int punti=0;
	private Griglia griglia=null;
	private int cont=0;
	private boolean reset=false;
	private boolean muove=false;
	private int move=0;
	public String point;
	public DBConnection db;
	public FPGameOver game;
	private Music music;

	public FPGame() {}
	
	public FPGame(final Griglia g,final FPGraphics graphics, Music music) {
		game=new FPGameOver();
		this.music = music;
		db= new DBConnection();
		this.graphics=graphics;
		griglia=g;
		cades=new Timer();
		task=new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						gameOver();
						punteggio();
						if(cont==0) {
							graphics.matrix();
						}
						else {
							setGravity();
							graphics.matrix();
						}
						cont++;
						
					}
				});
			}
		};
		cades.schedule(task,0,500);
	}
	
	/*metodo per la gestione del gameover nel quale viene memeorizzato lo score nel db*/
	public void gameOver() {
		if(griglia.dead()==true) {
			//cades.cancel();
			music.bm.stop();
			stage=(Stage) graphics.getScene().getWindow();
			scene=new Scene(game);
			stage.setScene(scene);
			stage.show();
			cades.cancel();
			db.insert(punti);
			
		}
	}
	
	public FPGameOver getGO() {
		return game;
		
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
		if(move>0)
			griglia.generationRiga();
		move=0;
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
				//System.out.println("Punti: "+p+" ");
			}
			point= Integer.toString(punti);
			//graphics.matrix();
		}
		
		this.griglia.resettaMoltiplicatore();
	}
	
	
	
	public void punteggio() {
		graphics.point.setText(point);
	}
	
	public int getPoint() {
		return punti;
	}
	
	public void muovi(int x,int y,boolean d_s) {
		Mattoni mattoneSelezionato=griglia.getMattoni()[x][y];
		if(mattoneSelezionato!=null) {
			//Movimento a destra true
			if(d_s==true) {
				
				switch (mattoneSelezionato.getTipo()) {
				case 1:{
					if(mattoneSelezionato.getWidth()<7 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+1][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+1][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						move++;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 2:{
					if(mattoneSelezionato.getWidth()<6 &&griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+2][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+2][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						move++;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 3:{
					if(mattoneSelezionato.getWidth()<5 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+3][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+3][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						move++;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
					break;
				}
				case 4:{
					if(mattoneSelezionato.getWidth()<4 && griglia.getMattonMatrix()[mattoneSelezionato.getWidth()+4][mattoneSelezionato.getHigh()]==0 && griglia.getMattoni()[mattoneSelezionato.getWidth()+4][mattoneSelezionato.getHigh()]==null ) {
						mattoneSelezionato.setWidth(mattoneSelezionato.getWidth()+1);
						move++;
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
						move++;
						griglia.aggiornaGriglia();
						graphics.matrix();
						griglia.caduta();
					}
				}
			}
			//System.out.println(move);
		}
		
		
	}
	
	
	

}
