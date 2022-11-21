import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonListingPage extends PageObject {

	public AmazonListingPage(WebDriver driver) {
		super(driver);
	}
	
	public String getProductTitle() {
		var productTitle = this.driver.findElement(By.cssSelector("#productTitle")).getText();
	
		return productTitle;
	}

}
