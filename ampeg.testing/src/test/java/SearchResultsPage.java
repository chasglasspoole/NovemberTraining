import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends PageObject {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public String findFirstSearchResult() {
		var searchResult = this.driver
				.findElement(By.cssSelector("#r1-0 a[data-testid='result-title-a']"))
				.getText();
				
		return searchResult;
	}

}
