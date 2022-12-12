package controlExtensions;

import org.openqa.selenium.WebElement;

public class Hyperlink extends ControlExtensions implements IHyperlink {

	public Hyperlink(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void click() {
		mappedElement.click();
	}

}