import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ArtistTests extends AmpegTests{
  @Test
  public void NavToDealerForArtistGear() {
	  var expectedTabName = "Online Retailers";
	  
	  var tabName = new HomePage(this.driver)
			  .clickArtistLink()
			  .clickSteveCook()
			  .clickGearLink()
			  .locateOnlineDealerTab();
	  
	  assertEquals(tabName, expectedTabName, "Should find Online Retailers tab");
  }
}
