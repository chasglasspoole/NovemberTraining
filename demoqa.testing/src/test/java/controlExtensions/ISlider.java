package controlExtensions;

import org.openqa.selenium.WebDriver;

public interface ISlider {

	String getValue();

	void setVaule(String value, WebDriver driver);
}