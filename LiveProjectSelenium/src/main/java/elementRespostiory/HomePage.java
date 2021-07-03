package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement carolThomasTab;

	@FindBy(xpath = "//a[@class='logout-btn']")
	WebElement logOutOption;

	@FindBy(xpath = "//h1[text()='Login']")
	WebElement loginText;
	
	@FindBy(xpath = "//a [@href='/payrollapp/user']")
	WebElement settingTab;
	
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']//h1[text()='Forbidden (#403)']")
	WebElement settingTabtext;

	@FindBy(xpath = "//img[@alt='logo']")
	WebElement logo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCarolThomasTab() {
		carolThomasTab.click();
	}

	public void clickLogOutOption() {
		logOutOption.click();
	}

	public String verifyLogOutFunction() {
		String logintext = generalUtil.getElementText(loginText);
		return logintext;
	}

	public void clickSetting() {
		generalUtil.ActionClass(driver, settingTab);
	}

	public String verifySettingFunction() {
		String Settingtext = generalUtil.getElementText(settingTabtext);
		return Settingtext;
	}

	public String verifyLogoFontSize() {
		String fontSize = generalUtil.getFontType(logo);
		return fontSize;
	}
}
