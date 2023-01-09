package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import foundation.DriverManager;
import foundation.DriverManagerFactory;

public abstract class AmpegTests {

	protected final String BASEURL = "https://ampeg.com/";
	protected DriverManager driverManager; 
	protected WebDriver driver;
	protected String driverType;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		this.launchDriver();
	}

	@AfterMethod
	public void Cleanup() {
		driverManager.quitDriver();
	}



	private void launchDriver() throws Exception {	 
		driverType = this.getDriverType();
		driverManager = DriverManagerFactory.getManager(driverType);
		driverManager.createDriver();
		driver = driverManager.getDriver();
		this.driver.navigate().to(BASEURL);
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