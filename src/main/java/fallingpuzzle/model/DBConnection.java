package fallingpuzzle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	
	

	public static void main(String[] args) {
		String url = "jdbc:sqlite:FallingPuzzle'sDB.db";
		Connection con;
		
		try {
			con = DriverManager.getConnection(url);
			if(con!=null && !con.isClosed()) {
				System.out.println("Connected succesfully");
				Statement stmt = con.createStatement();
			//	stmt.executeUpdate("INSERT INTO Punteggi VALUES ")
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
	
/*	public void insert(Connection con, String url) {
		
	}*/
    
}
