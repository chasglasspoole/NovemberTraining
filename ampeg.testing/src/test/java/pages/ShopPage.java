package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShopPage extends PageObject {
	
	@FindBy(how=How.XPATH, using = "//a[@aria-label='Hardware']/i")
	private WebElement productDropDown;
	
	

	public ShopPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public hardwareShopPage clickHardwareDropdown() {
		productDropDown.click();
		var pedalsOption = this.driver.findElement(By.xpath("//a[@aria-label='Pedals']"));
		pedalsOption.click();
		
		return new hardwareShopPage(this.driver, baseUrl);
	}
}