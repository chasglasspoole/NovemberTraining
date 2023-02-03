package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class hardwareShopPage extends PageObject {

	public hardwareShopPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ShoppingCartPage addItemToCart() {
		var addItemButton = this.driver
				.findElement(By.xpath("//a[@class='button button--primary add-to-cart'][1]"));
		addItemButton.click();
				
		return new ShoppingCartPage(this.driver, this.baseUrl);
	}
}