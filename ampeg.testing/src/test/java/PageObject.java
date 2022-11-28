import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	protected WebDriver driver;
	protected String URL;
	protected String baseUrl;

	protected PageObject(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
	}

	protected void switchActiveWindow() {
		String originalWindow = this.driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	/*protected PageObject navigateDirect() {
		String fullUrl = baseUrl + URL;
		this.driver.navigate().to(fullUrl);
		
		return new PageObject(this.driver, baseUrl);
	}*/
}
