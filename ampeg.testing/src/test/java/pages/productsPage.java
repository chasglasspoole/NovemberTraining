package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productsPage extends PageObject {

	public productsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String locateOnlineDealerTab() {
		var findDealersLink = this.driver.findElement(By.cssSelector("input[data-product=PN-115HLF"));
		findDealersLink.click();
		switchActiveWindow();
		var tabName = this.driver.findElement(By.cssSelector("li[class=oma-active]>a")).getText();
		
		return tabName;
	}
}
