package fallingpuzzle.model;

public class Mattoni {
	
	public static final Integer ONE=1;
	public static final Integer TWO=2;
	public static final Integer TREE=3;
	public static final Integer FOUR=4;
	private int mattHigh;
	private int mattWidth;
	private boolean selezionato=false;
	
	private int tipo;
	
	public Mattoni(Integer tipo,Integer mattWidth,Integer mattHigh) {
		this.tipo=tipo;
		this.mattHigh=mattHigh;
		this.mattWidth=mattWidth;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo=tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setWidth(Integer mattWidth) {
		this.mattWidth=mattWidth;
	}
	
	public int getWidth() {
		return mattWidth;
	}
	
	public void setHigh(Integer mattHigh) {
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
