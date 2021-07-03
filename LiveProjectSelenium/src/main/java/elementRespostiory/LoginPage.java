package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExcelRead;
import utilityClass.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtility generalutil = new GeneralUtility();

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement userLogged;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberMeCheckBOX;

	@FindBy(xpath = "//div[@class='form-group field-loginform-password required has-error']//p[@class='help-block help-block-error']")
	WebElement invalidText;

	@FindBy(xpath = "//a[@href='/payrollapp/site/request-password-reset']")
	WebElement resetLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean selectrememberMeCheckbox() {
		return rememberMeCheckBOX.isSelected();
	}

	public String verifyResetitLink() {
		String tagName = generalutil.getTagName(resetLink);
		return tagName;
	}

	public void enterUserName(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String password) {
		passWord.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public String verifyInvalidLoginMessage() {
		String inValidmsg = generalutil.getElementText(invalidText);
		return inValidmsg;
	}

	public String verifyLogin() {
		String userValue = generalutil.getElementText(userLogged);
		return userValue;
	}

	public void callImplicitWait(long time) {
		generalutil.applyImplicitWait(driver, 10);
	}

	public void excelLogin() {
		ExcelRead excel = new ExcelRead();
		userName.sendKeys(excel.getinputFromExcel(0, 0, 0));
		passWord.sendKeys(excel.getinputFromExcel(0, 0, 1));
		loginBtn.click();
	}

}
