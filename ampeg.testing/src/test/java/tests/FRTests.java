package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import pages.HomePage;

public class FRTests extends AmpegTests {
	@Test
	public void FR_004_CanViewArtists() {
		var artistsCount = new HomePage(this.driver, BASEURL)
				.clickArtistLink()
				.getArtistsCount();

		assertNotNull(artistsCount);
	}

	@Test
	public void FR_001_CanViewEndorsementForProduct() {

	}

	@Test
	public void FR_002_CanViewProductSpecifications() {
		var expectedResult = "LF Drivers: 8 x 10”\n"
				+ "Voice Coil: 2”\n"
				+ "Magnet Weight (each): 30 oz\n"
				+ "RMS Power Handling: 2 x 400-Watts (Stereo)\n"
				+ "RMS Power Handling: 800-Watts (Mono)\n"
				+ "Frequency Response (-3dB): 58Hz-5kHz\n"
				+ "Usable Low Frequency (-10dB): 40Hz\n"
				+ "Nominal Impedance: 2 x 8-Ohms (Stereo)\n"
				+ "Nominal Impedance: 4-Ohms (Mono)\n"
				+ "Sensitivity: 100dB\n"
				+ "Maximum SPL: 130dB\n"
				+ "Dimensions (W x H x D inches): 26 x 48 x 16\n"
				+ "Shipping Weight: 165 Pounds\n"
				+ "Handling Weight: 140 Pounds";

		var actualResult = new HomePage(this.driver, BASEURL)
				.enterSearch()
				.clickFirstResult()
				.getProductSpecs();

		assertEquals(expectedResult, actualResult, "Should return product specification");	  
	}

	@Test
	public void FR_003_CanFindProductDealers() {
		var expectedTabName = "Online Retailers";

		var tabName = new HomePage(this.driver, BASEURL)
				.enterSearch()
				.clickFirstResult()
				.locateOnlineDealerTab();

		assertEquals(expectedTabName, tabName, "Should return Online Dealers Tab name");
	}

	@Test
	public void FR_005_CanViewCartItems() throws InterruptedException {
		var expectedResult = "Your Cart (1 item)";

		var actualResult = new HomePage(this.driver, BASEURL)
				.clickShopLink()
				.clickHardwareDropdown()
				.addItemToCart()
				.getCartDescription();

		assertEquals(actualResult, expectedResult, "Should return quantity of items in cart");
	}
}