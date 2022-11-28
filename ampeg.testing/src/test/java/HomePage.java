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
	
	public ArtistPage clickArtistLink() {
		var artistLink = this.driver.findElement(By.cssSelector("a[title=Artists]"));
		artistLink.click();
		
		return new ArtistPage(this.driver);
	}
	
	public HomePage signIn(String user, String pass) {
		var loginIcon = this.driver.findElement(By.cssSelector("a[title=Account]"));
		loginIcon.click();
		var userNameBox = this.driver.findElement(By.cssSelector("input[name=l_user]"));
		userNameBox.sendKeys(user);
		var passwordBox = this.driver.findElement(By.cssSelector("input[name=l_pass]"));
		passwordBox.sendKeys(pass);
		var submitButton = this.driver.findElement(By.cssSelector("button[name=submit]"));
		submitButton.submit(); 
		
		return new HomePage(this.driver);
	}
	
	public String checkSignedIn() {
		var loginIcon = this.driver.findElement(By.cssSelector("a[title=Account]"));
		loginIcon.click();
		var welcomeText = this.driver.findElement(By.xpath("//*[@id='account-subnav']/div/div/div")).getText();
		
		return welcomeText;
		
	}
	
	public ShopPage clickShopLink() {
		var shopIcon = this.driver.findElement(By.cssSelector("a[title=Shop"));
		shopIcon.click();
		
		return new ShopPage(this.driver);
	}

}