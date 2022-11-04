import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
  @Test
  public void canGetStateName() {
	  var expectedState = "Texas";
	  
	  var actualState = States.Texas.Name;
	  
	  Assert.assertEquals(actualState, expectedState, "State name should be returned");
  }
  
  @Test
  public void canGetStateAbbreviation() {
	  var expectedAbbreviation = "TX";
	  
	  var actualAbbreviation = States.Texas.Abbreviation;
	  
	  Assert.assertEquals(actualAbbreviation, expectedAbbreviation, "State abbreviation should be returned");

  }
  
  @Test
  public void canGetStateNameFromObjectMother() {
	  var expectedState = "Louisiana";
	  
	  var actualState = getState(LocationObjectMothers.NewOrleans());
	  
	  Assert.assertEquals(actualState.Name, expectedState, "State name should be returned");
  }

private State getState(LocationObjectMother mother) {
	return mother.State;
}
}


