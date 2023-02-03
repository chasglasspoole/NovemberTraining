package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageObject {
	
	@FindBy(how=How.XPATH, using = "//a[@title='Artists']")
	private WebElement artistsButton;
	
	@FindBy(how=How.CSS, using = "a[title=Shop")
	private WebElement shopIcon;

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public SearchResultsPage enterSearch() {
		var searchIcon = this.driver.findElement(By.cssSelector("a[title=Search]"));
		searchIcon.click();
		var searchBar = this.driver.findElement(By.cssSelector("#searchq"));
		searchBar.sendKeys("svt-810e");
		searchBar.submit();
		
		return new SearchResultsPage(this.driver, baseUrl);
	}
	
	public HistoryPage clickHistoryLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title=History]"));
		menuLink.click();
		
		return new HistoryPage(this.driver, baseUrl);
	}
	
	public SupportPage clickSupportLink() {
		var supportLink = this.driver.findElement(By.cssSelector("a[title=Support]"));
		supportLink.click();
		
		return new SupportPage(this.driver, baseUrl);
	}
	
	public ArtistPage clickArtistLink() {
		var artistLink = artistsButton;
		artistLink.click();
		
		return new ArtistPage(this.driver, baseUrl);
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
		
		return new HomePage(this.driver, baseUrl);
	}
	
	public String checkSignedIn() {
		var loginIcon = this.driver.findElement(By.cssSelector("a[title=Account]"));
		loginIcon.click();
		var welcomeText = this.driver.findElement(By.xpath("//*[@id='account-subnav']/div/div/div")).getText();
		
		return welcomeText;
		
	}
	
	public ShopPage clickShopLink() {
		shopIcon.click();
		
		return new ShopPage(this.driver, baseUrl);
	}

}