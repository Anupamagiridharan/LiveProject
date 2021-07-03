package utilityClass;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {

	public String getElementText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public String getTagName(WebElement element) {
		String elementTagName = element.getTagName();
		return elementTagName;
	}

	public void applyImplicitWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public String gethtml(WebElement element, String html) {
		String htmlCode = element.getAttribute(html);
		return (htmlCode);
	}

	public String getTestColor(WebElement element) {
		String textColor = element.getCssValue("color");
		return textColor;
	}

	public String getBackGroundClor(WebElement element) {
		String bgColor = element.getCssValue("background-color");
		return bgColor;
	}

	public boolean getAttributeValue(WebElement element, String attrbtType, String attrbtValue) {
		boolean attributeValue = element.getAttribute(attrbtType).contains(attrbtValue);
		return attributeValue;

	}

	public void dropDownActionByVisibleText(WebElement element, String option) {
		Select Dropdown = new Select(element);
		Dropdown.selectByVisibleText(option);

	}

	public void dropDownActionByIndex(WebElement element, int index) {
		Select Dropdown = new Select(element);
		Dropdown.selectByIndex(index);
	}

	public void AlertdismissControl(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void AlertacceptControl(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
	}

	public String getPagTitle(WebDriver driver, WebElement element) {
		return driver.getTitle();
	}

	public List<String> dynamicLocator(WebDriver driver, String locator) {
		List<WebElement> firstColoums = driver.findElements(By.xpath(locator));
		List<String> textValues = new ArrayList<String>();
		for (int i = 0; i < firstColoums.size(); i++) {
			textValues.add(firstColoums.get(i).getText());
		}
		return textValues;
	}

	public String getFontType(WebElement element) {
		String fontType = element.getCssValue("font-Weight");
		return fontType;
	}

	public String getFontSize(WebElement element) {
		String fontSize = element.getCssValue("font-Weight");
		return fontSize;
	}
	public void ActionClass(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public String getCurrentPageUrl(WebDriver driver, WebElement element) {
		return driver.getCurrentUrl();
	}

}