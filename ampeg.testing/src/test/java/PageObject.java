import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	protected WebDriver driver;

	protected PageObject(WebDriver driver) {
		this.driver = driver;
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

}
