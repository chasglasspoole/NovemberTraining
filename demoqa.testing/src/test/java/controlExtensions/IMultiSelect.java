package controlExtensions;

import org.openqa.selenium.WebDriver;

public interface IMultiSelect {

	public String[] getSelectedOptions(WebDriver driver);

	void selectOptions(int selections, WebDriver driver);
}