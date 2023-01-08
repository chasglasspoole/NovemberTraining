import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;

public class ArtistTests extends AmpegTests{
  @Test
  public void navToDealerForArtistGear() {
	  var expectedTabName = "Online Retailers";
	  
	  var tabName = new HomePage(this.driver, BASEURL)
			  .clickArtistLink()
			  .clickSteveCook()
			  .clickGearLink()
			  .locateOnlineDealerTab();
	  
	  assertEquals(tabName, expectedTabName, "Should find Online Retailers tab");
  }
}
