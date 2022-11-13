package data.access;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SakilaQueries extends DatabaseUtility {
	private DatabaseAccessor db;
	
	public SakilaQueries(DatabaseAccessor db) {
		this.db = db;
	}
	

	public List<String> getCities() throws SQLException {
		var sql = "SELECT CITY FROM CITY ORDER BY CITY DESC LIMIT 10;";
	
		ArrayList<String> ar = new ArrayList<String>();
		ar = this.db.ExecuteSingleColumn(sql);
		
		return ar;
	}
	
	public String getHighestPayment() throws SQLException{
		var sql = "SELECT MAX(AMOUNT) AS 'Highest Payment' FROM PAYMENT;";
		
		var key = "Highest Payment";
		var queryResult = this.db.ExecuteSingleCell(sql, key);
		
		return queryResult;
	}


	public List<String[]> filmInfoView() throws SQLException {
		var sql = "SELECT * FROM FILM_LIST WHERE ACTORS LIKE \"%Bob Fawcett%\";";
		var ar = this.db.Execute(sql);
		return ar;
	}


	public List<String> filmInStockStoredProcedure(int fId) throws SQLException {
		var sql = "{CALL FILM_IN_STOCK(?, ?, ?)}";
		
		int filmId = fId;
		ArrayList<String> ar = new ArrayList<String>();
		ar = this.db.ExecuteStoredProcedure(sql, filmId);
		return ar;
	}
	
	public String getFilmId() throws SQLException {
		var sql = "SELECT FILM_ID FROM FILM WHERE TITLE LIKE \"%Alien Center%\""; 
		
		var key = "FILM_ID";
		
		var queryResult = this.db.ExecuteSingleCell(sql, key);
		
		return queryResult;
	}
}
