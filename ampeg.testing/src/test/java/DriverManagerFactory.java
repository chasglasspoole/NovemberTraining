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
			throw new Exception("Browser type not supported");
		}
		
		return driverManager;
	}
}