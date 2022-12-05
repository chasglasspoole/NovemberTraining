import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistPage extends PageObject {

	public ArtistPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public productsPage clickGearLink() {
		var gearLink = this.driver.findElement(By.linkText("PN-115HLF"));
		gearLink.click(); 
		
		return new productsPage(this.driver, baseUrl);
	}
	
	public ArtistPage clickSteveCook() {
		var steveCookLink = this.driver.findElement(By.linkText("Steve Cook"));
		steveCookLink.click();
		
		return new ArtistPage(this.driver, baseUrl);
	}
}
