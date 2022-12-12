import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonListingPage extends PageObject {

	public AmazonListingPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public String getProductTitle() {
		switchActiveWindow();
		var productTitle = this.driver.findElement(By.cssSelector("#productTitle")).getText();
	
		return productTitle;
	}

}
