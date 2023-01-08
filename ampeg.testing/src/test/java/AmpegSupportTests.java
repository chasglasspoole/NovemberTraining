import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;

public class AmpegSupportTests extends AmpegTests{
  @Test
  public void canFindVB4Manuals() {
	  var expectedTitle = "V-4B Manuals";
	  
	  var pageTitle = new HomePage(this.driver, BASEURL)
			  .clickSupportLink()
			  .clickCurrentManualsLink()
			  .clickV4BLink()
			  .getPageTitle();
	  
	  assertEquals(pageTitle, expectedTitle, "Should find title of V-4B owner manual");
  }
}
