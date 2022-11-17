package data.access;
import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests extends DatabaseTests {
	
	@Test
	public void canGetCities() throws SQLException {
		var expectedCities = new String[] {
				"Ziguinchor"
				,"Zhoushan"
				,"Zhezqazghan"
				,"Zeleznogorsk"
				,"Zaria"
				,"Zapopan"
				,"Zaoyang"
				,"Zanzibar"
				,"Zalantun"
				,"Yuzhou"};

		var actualCities = this.sakilaQueries.getCities();
		
		assertEquals(expectedCities, actualCities, "Query returns 10 cities in descending order");
	}
	
	@Test
	public void canGetHighestPayment() throws SQLException {
		var expectedHighestPayment = "11.99";
		
		var actualHighestPayment = this.sakilaQueries.getHighestPayment();
		
		assertEquals(actualHighestPayment, expectedHighestPayment, "Query returns highest payment");
	}
	
	@Test
	public void canUseAView() throws SQLException{
		var filmInfo = this.sakilaQueries.filmInfoView();
		for(String[] s : filmInfo) {
			System.out.println(Arrays.toString(s));
		}
	}
	
	@Test
	public void canUseAProcedure() throws SQLException{
		var expectedResult = new String[] {"73","74","75", "76"};
		
		var actualResult = this.sakilaQueries.filmInStockStoredProcedure();
		
		assertEquals(actualResult, expectedResult, "Procedure returns 4 inventory IDs");
	}
	
}