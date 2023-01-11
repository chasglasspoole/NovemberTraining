package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends PageObject {
	
	@FindBy(how=How.CLASS_NAME, using = "page-heading")
	private WebElement cartDescription;

	protected ShoppingCartPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public String getCartDescription() {
		return cartDescription.getAttribute("innerText");
		
	}

}
