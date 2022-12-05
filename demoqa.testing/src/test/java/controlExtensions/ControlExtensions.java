package controlExtensions;

import org.openqa.selenium.WebElement;

public abstract class ControlExtensions {
	
	protected WebElement mappedElement;

	public ControlExtensions(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
}