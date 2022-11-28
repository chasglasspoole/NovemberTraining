import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportPage extends PageObject {

	public SupportPage(WebDriver driver) {
		super(driver);
	}
	
	public ManualsPage clickCurrentManualsLink() {
		var currentManualsLink = this.driver.findElement(By.cssSelector("a[href='https://ampeg.com/support/manuals/'"));
		currentManualsLink.click();
		
		return new ManualsPage(this.driver);
	}

}
