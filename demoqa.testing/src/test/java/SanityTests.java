import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class SanityTests extends TestBase{
  @Test
  public void canLaunchWebDriver() {
	  var expectedUrl = "https://demoqa.com/";
	  
	  var actualUrl = driver.getCurrentUrl();
	  
	  assertEquals(actualUrl, expectedUrl, "Should return the same url"); 
  }
}