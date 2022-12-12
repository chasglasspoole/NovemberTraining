import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class HyperlinkTests extends TestBase {
  @Test
  public void canClickLink() {
	  var expectedResult = "Link has responded with staus 200 and status text OK";
	  
	  var actualResult = new LinksPage(this.driver, this.BASEURL)
			  .clickCreatedLink();
	  
	  assertEquals(actualResult, expectedResult, "Should return a status message");
  }
}