package appium.testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder; 

public abstract class AndroidClockTests {

	public AndroidClockApi androidClockApi;
	protected AndroidDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		/*AppiumServiceBuilder builder = new AppiumServiceBuilder(); 
		builder.withIPAddress("127.0.0.1")
		.usingPort(4723);
		this.driver = launchViaBuilder(builder);
		
		* For launching with Appium service builder
		*
		*/
		
		
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		this.driver = launchViaUrl(remoteUrl); 
		this.androidClockApi = new AndroidClockApi(driver);
	}
	
	@AfterTest
	public void cleanUp() {
		kill();
	}

	private void kill() {
		driver.quit();
	}
	
	public AndroidDriver launchViaBuilder(AppiumServiceBuilder builder){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:avd", "Nexus_S_API_30");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    
	    AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		return new AndroidDriver(service, desiredCapabilities);
	}
	
	public AndroidDriver launchViaUrl(URL remoteUrl) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:avd", "Nexus_S_API_30");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    
		return new AndroidDriver(remoteUrl, desiredCapabilities);

	}
}
