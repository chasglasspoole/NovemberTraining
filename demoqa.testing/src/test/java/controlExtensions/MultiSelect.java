package controlExtensions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelect extends ControlExtensions implements IMultiSelect{

	public MultiSelect(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void selectOptions(int selections, WebDriver driver) {
		driver.switchTo().defaultContent();
		mappedElement.click();
		for(int i = 0; i < selections; i++) {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
	}

	@Override
	public String[] getSelectedOptions(WebDriver driver) {
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='css-12jo7m5']")));
		List<WebElement> SelectedOptionsElements = driver.findElements(By.xpath("//div[@class='css-12jo7m5']"));
		ArrayList<String> selectedOptions = new ArrayList<String>();
		for(WebElement option : SelectedOptionsElements) {
			selectedOptions.add(option.getText());
		}
		return selectedOptions.toArray(String[]::new);
	}
}