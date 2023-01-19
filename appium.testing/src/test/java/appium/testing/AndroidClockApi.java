package appium.testing;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class AndroidClockApi {

	private AndroidDriver driver;

	public AndroidClockApi(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickAlarmButton() {
		this.driver.findElement(By
		.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Alarm\"]/android.widget.ImageView"))
		.click();
	}
	
	public String get830Alarm() {
		var alarmPage = this.driver.findElement(By.id("com.android.deskclock:id/alarms_recycler_view"));
		var time = alarmPage.findElement(By.id("com.android.deskclock:id/digital_clock"))
				.getAttribute("content-desc").toString();
		return time;
	}

	public String setAnAlarm() {
		var alarmCheck = this.driver.findElement(By.id("com.android.deskclock:id/onoff"));
		alarmCheck.click();
		
		return alarmCheck.getAttribute("checked");
	}
}
