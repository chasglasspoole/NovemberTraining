package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;

public class AmpegShopTests extends AmpegTests {
  @Test
  public void canAddItemToCart() throws InterruptedException {
	  var expectedResult = "1";
	  
	  var actualResult = new HomePage(this.driver, BASEURL)
			  .clickShopLink()
			  .clickHardwareDropdown()
			  .addItemToCart();
	  
	  assertEquals(actualResult, expectedResult, "Should return quantity of items in cart");
  }
}
