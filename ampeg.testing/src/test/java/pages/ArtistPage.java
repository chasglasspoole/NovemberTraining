package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtistPage extends PageObject {

	public ArtistPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ProductsPage clickGearLink() {
		var gearLink = this.driver.findElement(By.linkText("PN-115HLF"));
		gearLink.click(); 

		return new ProductsPage(this.driver, baseUrl);
	}

	public ArtistPage clickSteveCook() {
		var steveCookLink = this.driver.findElement(By.linkText("Steve Cook"));
		steveCookLink.click();

		return new ArtistPage(this.driver, baseUrl);
	}

	public int getArtistsCount() {
		List<WebElement> artistsList = new ArrayList<WebElement>();

		artistsList = this.driver.findElements(By.xpath("//span[@class='nombre']")); 
		var artistCount = artistsList.size();

		return artistCount; 
	}
}
