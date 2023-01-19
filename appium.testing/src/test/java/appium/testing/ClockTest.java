package appium.testing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ClockTest extends AndroidClockTests {
  @Test
  public void canClickAlarmButton() {
	  var expectedTime = "8:30 AM";
	  
	  this.androidClockApi.clickAlarmButton();
	  var time = this.androidClockApi.get830Alarm();
	  
	  assertEquals(time, expectedTime, "Returned incorrect value for Alarm time:");  
  }

  @Test
  public void canSetAnAlarm() {
	  var expectedResult = "true";
	  
	  var actualResult = this.androidClockApi.setAnAlarm();
	  
	  assertEquals(actualResult, expectedResult, "Incorrect result of Alarm checked: ");
  }
}
