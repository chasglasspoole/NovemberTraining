import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
  @Test
  public void canGetStateName() {
	  var expectedState = "Texas";
	  
	  var actualState = States.Texas.Name;
	  
	  Assert.assertEquals(actualState, expectedState, "State name should be returned.");
  }
  
  @Test
  public void canGetStateAbbreviation() {
	  var expectedAbbreviation = "TX";
	  
	  var actualAbbreviation = States.Texas.Abbreviation;
	  
	  Assert.assertEquals(actualAbbreviation, expectedAbbreviation, "State abbreviation should be returned.");

  }
  
  @Test
  public void canGetNewStateName() {
	  var expectedName = "New York";
	  
	  var actualName = States.NewYork.Name;
	  
	  Assert.assertEquals(actualName, expectedName, "State name should be returned.");
  }
  
  @Test
  public void canGetNewStateAbbreviation() {
	  var expectedAbbreviation = "NY";
	  
	  var actualAbbreviation = States.NewYork.Abbreviation;
	  
	  Assert.assertEquals(actualAbbreviation, expectedAbbreviation, "State abbreviation should be returned.");
  }
  
  @Test
  public void canGetCityName() {
	  var expectedCity = "New Orleans";
	  
	  var actualCity = cities.NewOrleans.Name;
	  
	  Assert.assertEquals(actualCity, expectedCity, "City Name should be returned.");
  }
  
  @Test
  public void canGetZipcode() {
	  var expectedZipcode = "70125";
	  
	  var actualZipcode = cities.NewOrleans.Zipcode;
	  
	  Assert.assertEquals(actualZipcode, expectedZipcode, "City Zipcode should be returned.");
  }
  
  @Test
  public void canGetStateNameFromObjectMother() {
	  var expectedState = "Louisiana";
	  
	  var actualState = getState(LocationObjectMothers.NewOrleans());
	  
	  Assert.assertEquals(actualState.Name, expectedState, "State name should be returned.");
  }
  
  @Test
  public void canGetNewStateNameFromObjectMother() {
	  var expectedState = "Texas";
	  
	  var actualState = getState(LocationObjectMothers.Houston());
	  
	  Assert.assertEquals(actualState.Name, expectedState, "State name should be returned.");
  }
  
  @Test
  public void canGetZipcodeFromObjectMother() {
	  var expectedZipcode = "77010";
	  
	  var actualZipcode = getZipcode(LocationObjectMothers.Houston());
	  
	  Assert.assertEquals(actualZipcode, expectedZipcode, "City Zipcode should be returned");
  }

  private Object getZipcode(LocationObjectMother mother) {	
	return mother.City.Zipcode;
  }

  private State getState(LocationObjectMother mother) {
	return mother.State;
  }
}


