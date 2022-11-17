package data.access;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SakilaQueries {
	private DatabaseAccessor accessor;
	
	public SakilaQueries(DatabaseAccessor databaseUtility) {
		this.accessor = databaseUtility;
	}
	

	public String[] getCities() throws SQLException {
		var sql = "SELECT CITY FROM CITY ORDER BY CITY DESC LIMIT 10;";
	
		
		var citiesArray = this.accessor.ExecuteSingleColumn(sql);
		
		return citiesArray;
	}
	
	public String getHighestPayment() throws SQLException{
		var sql = "SELECT MAX(AMOUNT) AS 'Highest Payment' FROM PAYMENT;";
		
		var key = "Highest Payment";
		var queryResult = this.accessor.ExecuteSingleCell(sql, key);
		
		return queryResult;
	}


	public List<String[]> filmInfoView() throws SQLException {
		var sql = "SELECT * FROM FILM_LIST WHERE ACTORS LIKE \"%Bob Fawcett%\";";
		var resultArray = this.accessor.Execute(sql);
		return resultArray;
	}


	public String[] filmInStockStoredProcedure() throws SQLException {
		var sql = "call film_in_stock((SELECT FILM_ID FROM FILM WHERE TITLE LIKE \"%Alien Center%\"), 2, @out_value)}";
		
		var resultArray = this.accessor.ExecuteStoredProcedure(sql);
		
		return resultArray;
	}
	
	public String getFilmId() throws SQLException {
		var sql = "SELECT FILM_ID FROM FILM WHERE TITLE LIKE \"%Alien Center%\""; 
		
		var key = "FILM_ID";
		
		var queryResult = this.accessor.ExecuteSingleCell(sql, key);
		
		return queryResult;
	}
}