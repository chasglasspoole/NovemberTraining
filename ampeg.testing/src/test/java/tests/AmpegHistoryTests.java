package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;

public class AmpegHistoryTests extends AmpegTests {
	@Test
	public void canFindHistoryBookOnAmazon() {
		var expectedTitle = "Ampeg: The Story Behind the Sound";

		var bookTitle = new HomePage(this.driver, BASEURL)
				.clickHistoryLink()
				.clickAmazonLink()
				.getProductTitle();

		assertEquals(bookTitle, expectedTitle, "Should find correct book title");
	}
}
