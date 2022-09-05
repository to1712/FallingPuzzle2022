package fallingpuzzle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static String url;
	private static Connection con;
    private static int maxScore;
	
		public DBConnection() {
			try {
				url = "jdbc:sqlite:FallingPuzzle'sDB.db";
				con = DriverManager.getConnection(url);
				MaxScore();
			    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			      }
							
		  	};
		
	/*metodo per l'inserimento del punteggio nel DB*/
	public void insert(int punti) {
		Statement stmt;
		try {
			stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO Punteggi VALUES ("+punti+") ");
			//stmt.executeUpdate("INSERT INTO Punteggi VALUES (5) ");
		     stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void MaxScore() {
		String query = "select max(score) from Punteggi";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		//	System.out.println("Punteggio massimo: "+rs.getInt(1));
			maxScore = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getMaxScore() {
		return maxScore;
	}
    
}
