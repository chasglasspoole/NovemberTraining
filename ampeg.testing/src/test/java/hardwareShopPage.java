import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class hardwareShopPage extends PageObject {

	public hardwareShopPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String addItemToCart() throws InterruptedException {
		var addItemButton = this.driver
				.findElement(By.xpath("//a[contains(.,'Classic Analog Bass Preamp Pedal')]/../../..//button"));
		addItemButton.click();
		
		Thread.sleep(2000);
		
		var shopCartIcon = this.driver.findElement(By.xpath("//a[@class='action showcart']"));
		shopCartIcon.click();
		
		var cartItems = this.driver.findElement(By.xpath("//div[@id='minicart-content-wrapper']//span[@class='count']")).getText();
		
		return cartItems;
	}
}