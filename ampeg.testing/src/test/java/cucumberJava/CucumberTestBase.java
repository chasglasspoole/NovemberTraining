package cucumberJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import foundation.DriverManager;
import foundation.DriverManagerFactory;

public class CucumberTestBase {

	protected DriverManager driverManager; 
	protected WebDriver driver;
	protected String driverType;

	@AfterMethod
	public void Cleanup() {
		driverManager.quitDriver();
	}

	public void launchDriver(String url) throws Exception {	 
		driverType = this.getDriverType();
		driverManager = DriverManagerFactory.getManager(driverType);
		driverManager.createDriver();
		driver = driverManager.getDriver();
		this.driver.navigate().to(url);
	}

	private String getDriverType() {
		Scanner driverScan = null;

		File file = new File("DriverType.txt"); 

		try {
			driverScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		driverScan.useDelimiter("\"");
		String driverType = "";
		while(driverScan.hasNext()) {
			driverType = driverScan.next();
		}
		driverScan.close();
		return driverType;
	}
}
