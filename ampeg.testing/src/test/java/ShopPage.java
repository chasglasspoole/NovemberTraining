import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends PageObject {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	public hardwareShopPage clickHardwareDropdown() {
		var pedalsDropdown = this.driver.findElement(By.xpath("//a[@id='ui-id-3']"));
		pedalsDropdown.click();
		
		return new hardwareShopPage(this.driver);
	}
}