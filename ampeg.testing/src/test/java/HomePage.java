import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public SearchResultsPage enterSearch() {
		var searchIcon = this.driver.findElement(By.cssSelector("a[title=Search]"));
		searchIcon.click();
		var searchBar = this.driver.findElement(By.cssSelector("#searchq"));
		searchBar.sendKeys("svt-810e");
		searchBar.submit();
		
		return new SearchResultsPage(this.driver);
	}
	
	public HistoryPage clickHistoryLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title=History]"));
		menuLink.click();
		
		return new HistoryPage(this.driver);
	}
	
	public SupportPage clickSupportLink() {
		var supportLink = this.driver.findElement(By.cssSelector("a[title=Support]"));
		supportLink.click();
		
		return new SupportPage(this.driver);
	}
	
	public artistPage clickArtistLink() {
		var artistLink = this.driver.findElement(By.cssSelector("a[title=Artists]"));
		artistLink.click();
		
		return new artistPage(this.driver);
	}

}
