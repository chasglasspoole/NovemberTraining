import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	private WebDriver driver;

	public abstract void createDriver(); 

	public WebDriver getDriver() {
		return driver;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void quitDriver() {
		if (null != this.driver) {
			this.driver.quit();
			this.driver = null;
		}
	}
}