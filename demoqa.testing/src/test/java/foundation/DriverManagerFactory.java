package foundation;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String browserType) {
		
		DriverManager driverManager = null;
		
		switch(browserType) {
		case "CHROME":
			driverManager = new ChromeDriverManager();
			break;
		case "EDGE":
			driverManager = new EdgeDriverManager();
			break;
		default:
			//driverManager = new ChromeDriverManager();
			break;
		}
		
		return driverManager;
	}
}