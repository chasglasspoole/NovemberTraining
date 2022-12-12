package controlExtensions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider extends ControlExtensions implements ISlider {

	public Slider(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setVaule(String value, WebDriver driver) {
		Dimension sliderSize = mappedElement.getSize();
		int sliderWidth = sliderSize.getWidth();
		int startPoint = sliderWidth/2;
		int val = Integer.parseInt(value);

		Actions moveToStart = new Actions(driver);   
		moveToStart.moveToElement(mappedElement).moveByOffset(-startPoint, 0).click().build().perform();

		for(int i = 0; i <= val-1; i++) {
			mappedElement.sendKeys(Keys.ARROW_RIGHT);	
		}	
		return;
	}

	@Override
	public String getValue() {
		return mappedElement.getAttribute("value");
	}

}