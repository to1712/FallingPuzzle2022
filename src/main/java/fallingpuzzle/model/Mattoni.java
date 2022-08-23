package fallingpuzzle.model;

public class Mattoni {
	public static final int ONE=1;
	public static final int TWO=2;
	public static final int TREE=3;
	public static final int FOUR=4;
	private int mattHigh;
	private int mattWidth;
	private boolean selezionato=false;
	
	private int tipo;
	
	public Mattoni(int tipo,int mattHigh,int mattWidth) {
		this.tipo=tipo;
		this.mattHigh=mattHigh;
		this.mattWidth=mattWidth;
	}
	
	public void setTipo(int tipo) {
		this.tipo=tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setWidth(int mattWidth) {
		this.mattWidth=mattWidth;
	}
	
	public int getWidth() {
		return mattWidth;
	}
	
	public void setHigh(int mattHigh) {
		this.mattHigh=mattHigh;
	}
	
	public int getHigh() {
		return mattHigh;
	}
	
	public void setSelezionato(boolean selezionato) {
		this.selezionato=selezionato;
	}
	public boolean eSelezionato() {
		return selezionato;
	}
	
	
}
