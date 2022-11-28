import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBarTest extends AmpegTests {
  @Test
  public void ensureCorrectSearchResultDisplayed() {
	  var expectedResult = "Ampeg: Classic Series - SVT-810E";
	  
	  var searchResult = new HomePage(this.driver, BASEURL)
			  .enterSearch()
			  .findFirstSearchResult();
	  
	  Assert.assertEquals(searchResult, expectedResult, "Search should find Ampeg: Classic Series - SVT-810E");
  }
}
