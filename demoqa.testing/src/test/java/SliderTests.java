import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class SliderTests extends TestBase {
  @Test
  public void canSetSliderTo80() {
	  var expectedValue = "80";
	  
	  var actualValue = new SliderPage(this.driver, this.BASEURL)
			  .moveSlider(expectedValue)
			  .getSliderValue();
	  
	  assertEquals(actualValue, expectedValue, "Should return slider value");
  }
  
  @Test
  public void canSetSliderTo17() {
	  var expectedValue = "17";
	  
	  var actualValue = new SliderPage(this.driver, this.BASEURL)
			  .moveSlider(expectedValue)
			  .getSliderValue();
	  
	  assertEquals(actualValue, expectedValue, "Should return slider value");
  }
  
  @Test
  public void canSetSliderToZero() {
	  var expectedValue = "0";
	  
	  var actualValue = new SliderPage(this.driver, this.BASEURL)
			  .moveSlider(expectedValue)
			  .getSliderValue();
	  
	  assertEquals(actualValue, expectedValue, "Should return slider value");
  }
  
  @Test
  public void canSetSliderTo100() {
	  var expectedValue = "100";
	  
	  var actualValue = new SliderPage(this.driver, this.BASEURL)
			  .moveSlider(expectedValue)
			  .getSliderValue();
	  
	  assertEquals(actualValue, expectedValue, "Should return slider value");
  }
}
