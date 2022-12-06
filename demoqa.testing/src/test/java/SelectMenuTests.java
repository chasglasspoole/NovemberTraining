import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class SelectMenuTests extends TestBase {
  @Test
  public void canSetValueFromDropdown() {
	  var expectedValue = "Black";
	  
	  var valueIndex = "5";
	  var actualValue = new SelectMenuPage(this.driver, this.BASEURL)
			  .setMenuItem(valueIndex)
			  .getMenuValue();
	  
	  assertEquals(actualValue, expectedValue, "Should return a value from dropdown");
  }
  
  @Test
  public void canGetAllMenuOptions() {
	  String[] expectedOptions = {"Red","Blue","Green","Yellow","Purple","Black","White","Voilet","Indigo","Magenta","Aqua"};
	  
	  var actualOptions = new SelectMenuPage(this.driver, this.BASEURL)
			  .getAllOptions(); 
	  
	  assertEquals(actualOptions, expectedOptions, "Should return all options");

  }
  
  @Test
  public void canSelectMultipleOptions() {
	  String[] expectedSelectedOptions = {"Blue","Green"};
	  
	  var selections = 2;
	  var actualSelectedOptions = new SelectMenuPage(this.driver, this.BASEURL)
			  .selectMultipleItem(selections);
	  
	  assertEquals(actualSelectedOptions, expectedSelectedOptions, "Should return all selected options");
  }
}