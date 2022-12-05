import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensions.Hyperlink;
import foundation.PageObject;

public class LinksPage extends PageObject {

	@FindBy(how=How.ID, using="created")
	private WebElement linkElement;
	
	private String url = "links/"; 

	protected LinksPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String clickCreatedLink() {
		navigateDirect(url);
		Hyperlink hyperlink = new Hyperlink(linkElement);
		hyperlink.click();
		var responseText = this.driver.findElement(By.cssSelector("#linkResponse")).getText();
		return responseText; 
	}
}
