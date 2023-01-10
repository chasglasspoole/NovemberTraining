package cucumberJava;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Annotation extends CucumberTestBase{
	
	
	@Given("I am on the Ampeg home page$")
	public void goToAmpegHomepage() throws Exception {
		launchDriver("https://ampeg.com/");
	}
	
	@When("^I search for a product$")
	public void searchProduct() {
		var searchIcon = this.driver.findElement(By.cssSelector("a[title=Search]"));
		searchIcon.click();
		var searchBar = this.driver.findElement(By.cssSelector("#searchq"));
		searchBar.sendKeys("svt-810e");
		searchBar.submit();
	}
	
	@And("^I click on the result$")
	public void clickFirstResult() {
		var searchResult = this.driver.findElement(By.cssSelector("#r1-0 a[data-testid='result-title-a']"));
		searchResult.click();
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
		
		assertEquals(expectedResult, specs, "Should return product specification");
	}
	
}