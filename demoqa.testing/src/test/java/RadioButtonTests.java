import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import foundation.TestBase;

public class RadioButtonTests extends TestBase {
	
public static final Class<NoSuchElementException> NSE = NoSuchElementException.class;
  @Test
  public void canSelectYesRadioButton() {
	  var expectedLabel = "Yes";
	  
	  var actualLabel = new RadioButtonPage(this.driver, this.BASEURL)
			  .selectRadioButton("Yes");
	  
	  assertEquals(actualLabel, expectedLabel, "Should return radio button label");
			  
  }
  
  @Test
  public void canSelectImpressiveRadioButton() {
	  var expectedLabel = "Impressive";

	  var actualLabel = new RadioButtonPage(this.driver, this.BASEURL)
			  .selectRadioButton("Impressive");

	  assertEquals(actualLabel, expectedLabel, "Should return radio button label");

  }
  
  @Test
  public void canNotSelectNoRadioButton() {
	  
	  
	  assertThrows(NSE, () -> new RadioButtonPage(this.driver, this.BASEURL).selectRadioButton("No"));
	  

  }
}
