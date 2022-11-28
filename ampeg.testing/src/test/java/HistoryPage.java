import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends PageObject {

	public HistoryPage(WebDriver driver) {
		super(driver);
	}

	public AmazonListingPage clickAmazonLink() {
		var amazonLink = this.driver.findElement(By.xpath("//a[text()='Amazon.com']"));
		amazonLink.click();
		
		return new AmazonListingPage(this.driver);
	}
}
