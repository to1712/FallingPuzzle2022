package fallingpuzzle.model;

public class Block {
		public static final int EMPTY=0;
		public static final int ONE=1;
		public static final int TWO=2;
		public static final int TREE=3;
		public static final int FOUR=4;
		
		private int tipo;
		
		public Block(int tipo) {
			this.tipo=tipo;
		}
		public void setTipo(int tipo) {
			this.tipo=tipo;
		}
		public int getTipo() {
			return tipo;
		}
		
		
}
