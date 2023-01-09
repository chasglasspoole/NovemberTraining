package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage extends PageObject {
	
	@FindBy(how=How.XPATH, using = "//div[@class='specsCopy']")
	private WebElement specText;
	
	@FindBy(how=How.XPATH, using = "//input[@data-product='SVT-810E']")
	private WebElement findDealersElement;

	
	public ProductsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String locateOnlineDealerTab() {
		findDealersElement.click();
		switchActiveWindow();
		var tabName = this.driver.findElement(By.cssSelector("li[class=oma-active]>a")).getText();
		
		return tabName;
	}
	
	public String getProductSpecs() {
		var specs = specText.getText();
		return specs;
	}
}
