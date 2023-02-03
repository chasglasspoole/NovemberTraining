package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
	protected WebDriver driver;
	protected String URL;
	protected String baseUrl;

	protected PageObject(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		
		InitPageFactory();
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
	
	private void InitPageFactory() {
		PageFactory.initElements(this.driver, this);
	}
}
