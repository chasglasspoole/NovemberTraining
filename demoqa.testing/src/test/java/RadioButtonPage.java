import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensions.RadioButton;
import controlExtensions.RadioGroup;
import foundation.PageObject;

public class RadioButtonPage extends PageObject {
	private String url = "radio-button/";
	
	@FindBy(how=How.XPATH, using="//div[@class='mb-3']/..")
	private WebElement radioGroupElement;

	protected RadioButtonPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String selectRadioButton(String label) {
		navigateDirect(url);
		RadioGroup radioGroup = new RadioGroup(radioGroupElement);
		RadioButton button = radioGroup.getButton(label);
		button.select(this.driver);
		String selectedLabel = radioGroup.getSelected();
		return selectedLabel;
	}
	
	public boolean isButtonEnabled(String label) {
		navigateDirect(url);
		RadioGroup radioGroup = new RadioGroup(radioGroupElement);
		RadioButton button = radioGroup.getButton(label);
		return button.isEnabled();
	}
}