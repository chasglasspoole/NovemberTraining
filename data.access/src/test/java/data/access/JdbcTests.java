package data.access;
import java.sql.SQLException;
import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private SakilaQueries accessor;
	private DatabaseAccessor db;
	
	@BeforeMethod
	public void Setup() {
		this.db = new DatabaseUtility();
		this.accessor = new SakilaQueries(db);
	}
	
	
	@Test
	public void canGetCities() throws SQLException {
		var cities = this.accessor.getCities();
		System.out.println(Arrays.toString(cities.toArray()));
	}
	
	@Test
	public void canGetHighestPayment() throws SQLException {
		var highestPayment = this.accessor.getHighestPayment();
		System.out.println(highestPayment);
	}
	
	@Test
	public void canUseAView() throws SQLException{
		var filmInfo = this.accessor.filmInfoView();
		for(String[] s : filmInfo) {
			System.out.println(Arrays.toString(s));
		}
	}
	
	@Test
	public void canUseAProcedure() throws SQLException{
		var filmId = this.accessor.getFilmId();
		int fId = Integer.parseInt(filmId);
		var inventoryIds = this.accessor.filmInStockStoredProcedure(fId);
		System.out.println(Arrays.toString(inventoryIds.toArray()));
	}
	
}
 
