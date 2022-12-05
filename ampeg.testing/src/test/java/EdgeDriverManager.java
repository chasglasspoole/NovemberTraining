import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\chase\\Downloads\\edgedriver_win32\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);

		WebDriver driver;
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		setDriver(driver);
	}

}