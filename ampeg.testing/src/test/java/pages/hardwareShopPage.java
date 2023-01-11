package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class hardwareShopPage extends PageObject {

	public hardwareShopPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ShoppingCartPage addItemToCart() throws InterruptedException {
		var addItemButton = this.driver
				.findElement(By.xpath("//a[@class='button button--primary'][1]"));
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("arguments[0].click();", addItemButton);
				
		return new ShoppingCartPage(this.driver, this.baseUrl);
	}
}