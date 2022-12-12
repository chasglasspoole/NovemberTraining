package controlExtensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioGroup extends ControlExtensions implements IRadioGroup {

	public RadioGroup(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public RadioButton getButton(String label) {
		var xpath = "//label[.= '"+label+"']/../input";
		RadioButton radioButton = new RadioButton(mappedElement.findElement(By.xpath(xpath)));
		return radioButton;
	}

	@Override
	public String getSelected() {
		String selectedButtonLabel = mappedElement.findElement(By.xpath("//span[@class='text-success']")).getAttribute("innerHTML");
		return selectedButtonLabel;
	}
}