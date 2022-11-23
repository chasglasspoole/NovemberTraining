import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class artistPage extends PageObject {

	public artistPage(WebDriver driver) {
		super(driver);
	}

	public productsPage clickGearLink() {
		var gearLink = this.driver.findElement(By.linkText("PN-115HLF"));
		gearLink.click(); 
		
		return new productsPage(this.driver);
	}
	
	public artistPage clickSteveCook() {
		var steveCookLink = this.driver.findElement(By.linkText("Steve Cook"));
		steveCookLink.click();
		
		return new artistPage(this.driver);
	}
}
