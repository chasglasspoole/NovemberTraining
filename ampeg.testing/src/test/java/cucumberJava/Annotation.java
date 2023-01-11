package cucumberJava;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Annotation extends CucumberTestBase{


	@Given("^I am on the Ampeg home page$")
	public void goToAmpegHomePage() throws Exception {
		launchDriver("https://ampeg.com/");
	}

	@Given("^I am on a product page$")
	public void goToProductPage() throws Exception {
		launchDriver("https://ampeg.com/products/classic/svt810e/");
	}

	@When("^I search for a product$")
	public void searchProduct() {
		var searchIcon = this.driver.findElement(By.cssSelector("a[title=Search]"));
		searchIcon.click();
		var searchBar = this.driver.findElement(By.cssSelector("#searchq"));
		searchBar.sendKeys("svt-810e");
		searchBar.submit();
	}

	@When("^I click on find a dealer$")
	public void clickFindDealer() {
		var findDealerButton = this.driver.findElement(By.xpath("//input[@data-product='SVT-810E']"));
		findDealerButton.click();
	}

	@When("^I click on the artists button$")
	public void clickArtistsButton() {
		var artistLink = this.driver.findElement(By.xpath("//a[@title='Artists']"));
		artistLink.click();
	}

	@When("^I click on the shop button$")
	public void clickShopButton() {
		var shopLink = this.driver.findElement(By.cssSelector("a[title=Shop"));
		shopLink.click();
	}

	@And("^I click on the result$")
	public void clickFirstResult() {
		var searchResult = this.driver.findElement(By.cssSelector("#r1-0 a[data-testid='result-title-a']"));
		searchResult.click();
	}

	@And("^I add an item to my cart$")
	public void addItemToCart() {
		var productDropDown = this.driver.findElement(By.xpath("//a[@aria-label='Hardware']/i"));
		productDropDown.click();
		var pedalsOption = this.driver.findElement(By.xpath("//a[@aria-label='Pedals']"));
		pedalsOption.click();

		var addItemButton = this.driver
				.findElement(By.xpath("//a[@class='button button--primary'][1]"));
		JavascriptExecutor executor = (JavascriptExecutor)this.driver;
		executor.executeScript("arguments[0].click();", addItemButton);
	}

	@Then("^I can view the product specifications$")
	public void getProductSpecs() {
		var expectedResult = "LF Drivers: 8 x 10”\n"
				+ "Voice Coil: 2”\n"
				+ "Magnet Weight (each): 30 oz\n"
				+ "RMS Power Handling: 2 x 400-Watts (Stereo)\n"
				+ "RMS Power Handling: 800-Watts (Mono)\n"
				+ "Frequency Response (-3dB): 58Hz-5kHz\n"
				+ "Usable Low Frequency (-10dB): 40Hz\n"
				+ "Nominal Impedance: 2 x 8-Ohms (Stereo)\n"
				+ "Nominal Impedance: 4-Ohms (Mono)\n"
				+ "Sensitivity: 100dB\n"
				+ "Maximum SPL: 130dB\n"
				+ "Dimensions (W x H x D inches): 26 x 48 x 16\n"
				+ "Shipping Weight: 165 Pounds\n"
				+ "Handling Weight: 140 Pounds";

		var specs = this.driver.findElement(By.xpath("//div[@class='specsCopy']")).getText();

		assertEquals(specs, expectedResult, "Should return product specification");
	}

	@Then("^I can see the online retailers$")
	public void locateOnlineRetailersTab() {
		var expectedTabName = "Online Retailers";

		var tabName = this.driver.findElement(By.cssSelector("li[class=oma-active]>a")).getText();	

		assertEquals(tabName, expectedTabName, "Should find online retailers tab name");
	}

	@Then("^I can view all the artists$")
	public void getAllArtists() {
		List<WebElement> artistsList = new ArrayList<WebElement>();

		artistsList = this.driver.findElements(By.xpath("//span[@class='nombre']")); 
		var artistCount = artistsList.size();

		assertNotNull(artistCount);
	}

	@Then("^I can view items in my cart$")
	public void getCartDescription() {
		var expectedDesc = "Your Cart (1 item)";

		var cartDescription = this.driver.findElement(By.className("page-heading")).getAttribute("innerText");

		assertEquals(cartDescription, expectedDesc, "returns shopping cart contents description");
	}

	@After
	public void Cleanup() {
		driverManager.quitDriver();
	}
}