package fallingpuzzle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public DBConnection() {};
	
	private static String url = "jdbc:sqlite:FallingPuzzle'sDB.db";
	private static Connection con;
	public static FPGame fpg = new FPGame();
	private static int score = fpg.getPoint();

	public static void main(String[] args) {
		 url = "jdbc:sqlite:FallingPuzzle'sDB.db";
		
		try {
			con = DriverManager.getConnection(url);
			if(con!=null && !con.isClosed()) {
				System.out.println("Connected succesfully");
				System.out.println("Punteggio: "+score);
				Statement stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO Punteggi VALUES ("+score+") ");
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	public void insert(Connection con, String url) {
		
	}
    
}
