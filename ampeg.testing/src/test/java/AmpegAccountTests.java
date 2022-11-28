import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AmpegAccountTests extends AmpegTests {
  @Test
  public void canSignIn() {
	  var expectedText = "Welcome chaseglasspoole. Sign Out";
	  
	  var welcomeText = new HomePage(this.driver)
			  .signIn("chaseglasspoole", "Chaseman09")
			  .checkSignedIn();
	  
	  assertEquals(welcomeText, expectedText, "Should show welcome message"); 
  }
}
