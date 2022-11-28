import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class V4BManualsPage extends PageObject {

	public V4BManualsPage(WebDriver driver) {
		super(driver);
	}

	public V4BOwnerManualPdfPage clickEnglishOwnerManual() {
		var engOwnerManualLink = this.driver
				.findElement(By.cssSelector("a[href='/data/6/0a020a41e58d5e0b91edd46ce/application/pdf/Owner’s Manual - English .pdf']"));
		engOwnerManualLink.click();
		
		return new V4BOwnerManualPdfPage(this.driver);
	}
	
	public String getPageTitle() {
		var pageTitle = this.driver.findElement(By.cssSelector("h1[class=fancy]")).getText();
		
		return pageTitle;
	}
}
