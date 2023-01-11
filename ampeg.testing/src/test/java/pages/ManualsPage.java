package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManualsPage extends PageObject {

	public ManualsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public V4BManualsPage clickV4BLink() {
		var vb4Link = this.driver.findElement(By.cssSelector("a[alt='V-4B']"));
		vb4Link.click();

		return new V4BManualsPage(this.driver, baseUrl);
	}

}
