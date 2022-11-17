package data.access;

import org.testng.annotations.BeforeMethod;

public abstract class DatabaseTests {
	protected SakilaQueries sakilaQueries;
	
	@BeforeMethod 
	public void Setup() {
		var connectionString = "jdbc:mysql://localhost/sakila?user=root&password=P@ssw0rd";
		this.sakilaQueries = new SakilaQueries(new DatabaseUtility(connectionString));
	}
}
