package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class V4BOwnerManualPdfPage extends PageObject {

	public V4BOwnerManualPdfPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String findManualTitle() {
		switchActiveWindow();
		var pdfTitle = this.driver.findElement(By.cssSelector("span[id='title'")).getText();
		
		return pdfTitle;
	}
}
