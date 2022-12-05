package controlExtensions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect extends ControlExtensions implements IMultiSelect{

	public MultiSelect(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void selectOptions(String[] options) {
		Select selectMenu = new Select(mappedElement);
		for(String option : options) {
			selectMenu .selectByValue(option);
		}
	}

	@Override
	public String[] getSelectedOptions() {
		Select selectMenu = new Select(mappedElement);
		List<WebElement> SelectedOptionsElements = selectMenu.getAllSelectedOptions();
		ArrayList<String> selectedOptions = new ArrayList<String>();
		for(WebElement option : SelectedOptionsElements) {
			selectedOptions.add(option.getText());
		}
		return selectedOptions.toArray(String[]::new);
	}
}