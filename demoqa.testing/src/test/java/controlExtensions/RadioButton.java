package controlExtensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends ControlExtensions implements IRadioButton {

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void select(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", mappedElement);
	}

	@Override
	public boolean isEnabled() {
		return mappedElement.isEnabled();
	}
}