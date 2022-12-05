import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensions.Slider;
import foundation.PageObject;

public class SliderPage extends PageObject {
	private String url = "slider/";
	
	@FindBy(how=How.XPATH, using="//span[@class='range-slider__wrap']/input")
	private WebElement sliderElement;
	
	protected SliderPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public SliderPage moveSlider(String value) {
		navigateDirect(url);
		Slider slider = new Slider(sliderElement);
		slider.setVaule(value, this.driver);
		return this;
	}
	
	public String getSliderValue() {
		Slider slider = new Slider(sliderElement);
		var sliderValue = slider.getValue();
		return sliderValue; 
	}

	
}
