package fallingpuzzle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
	

	public static void main(String[] args) {
		String url = "jdbc:sqlite:FallingPuzzle'sDB.db";
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			if(con!=null && !con.isClosed()) {
				System.out.println("Connected succesfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
