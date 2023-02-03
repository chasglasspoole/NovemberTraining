package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportPage extends PageObject {

	public SupportPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public ManualsPage clickCurrentManualsLink() {
		var currentManualsLink = this.driver.findElement(By.xpath("//h4[.='CURRENT MANUALS']/.."));
		currentManualsLink.click();
		
		return new ManualsPage(this.driver, baseUrl);
	}

}
