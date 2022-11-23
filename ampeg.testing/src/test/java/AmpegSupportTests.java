import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AmpegSupportTests extends AmpegTests{
  @Test
  public void canFindVB4OwnerManual() {
	  var expectedTitle = "Ampeg V-4B Owner's Manual - Rev A, English";
	  
	  var manualTitle = new HomePage(this.driver)
			  .clickSupportLink()
			  .clickCurrentManualsLink()
			  .clickV4BLink()
			  .clickEnglishOwnerManual()
			  .findManualTitle();
	  
	  assertEquals(manualTitle, expectedTitle, "Should find title of V-4B owner manual");
  }
}
