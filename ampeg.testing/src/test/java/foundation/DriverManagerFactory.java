package foundation;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String browserType) throws Exception {
		
		DriverManager driverManager = null;
		
		switch(browserType) {
		case "CHROME":
			driverManager = new ChromeDriverManager();
			break;
		case "EDGE":
			driverManager = new EdgeDriverManager();
			break;
		default:
			throw new Exception("Driver not supported. Try using chrome or edge");
		}
		
		return driverManager;
	}
}