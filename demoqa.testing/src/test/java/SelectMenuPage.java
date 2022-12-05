import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import controlExtensions.MultiSelect;
import foundation.PageObject;

public class SelectMenuPage extends PageObject {
	private String url = "select-menu/";
	
	@FindBy(how=How.ID, using="cars")
	private WebElement multiSelectMenuElement;
	
	@FindBy(how=How.ID, using="oldSelectMenu")
	private WebElement oldSelectMenuElement;

	protected SelectMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
		
	
	public SelectMenuPage setMenuItem(String value) {
		navigateDirect(url);
		Select selectMenuObj = new Select(oldSelectMenuElement);
		selectMenuObj.selectByValue(value);
		return this;
	}

	public String getMenuValue() {
		Select selectMenuObj = new Select(oldSelectMenuElement);
		WebElement selectedValueElement = selectMenuObj.getFirstSelectedOption();
		return selectedValueElement.getText();
	}


	public String[] getAllOptions() {
		navigateDirect(url);
		Select selectMenuObj = new Select(oldSelectMenuElement);
		List<WebElement> optionsElements = selectMenuObj.getOptions();
		ArrayList<String> options = new ArrayList<String>();
		for(WebElement option : optionsElements) {
			options.add(option.getText());
		}
		return options.toArray(String[]::new);
	}


	public String[] selectMultipleItem(String[] optionValues) {
		navigateDirect(url);
		MultiSelect menuElement = new MultiSelect(multiSelectMenuElement);
		menuElement.selectOptions(optionValues);
		
		return menuElement.getSelectedOptions();
	}
}