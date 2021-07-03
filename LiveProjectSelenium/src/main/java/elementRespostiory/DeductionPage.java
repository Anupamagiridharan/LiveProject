package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class DeductionPage {
	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();
	ExplictWait explicit = new ExplictWait();
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionTab;
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement dectHeader;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeTab;
	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement homePageHeader;
	@FindBy(xpath = "//a[text()='Add Deduction']")
	WebElement addDeductionTab;
	@FindBy(xpath = "//span[@class='select2-selection__arrow']")
	WebElement workersDropDownOption;
	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']//span[@class='select2-selection__rendered']")
	WebElement dennisBennyOption;
	@FindBy(xpath = "//select[@id='deduction-type']")
	WebElement titleDropDownOption;
	@FindBy(xpath = "//*[@id=\"deduction-type\"]/option[5]")
	WebElement BootsOption;
	@FindBy(xpath = "//input[@id='deduction-amount']")
	WebElement amount;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath = "//*[@id=\"w0\"]/tbody/tr[1]/td")
	WebElement addedDeductionPageHeader;

	public DeductionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDeductiontab() {
		deductionTab.click();
	}

	public void clickDeductionHeader() {
		dectHeader.click();
	}

	public String verifyDeductionHeader() {
		String Text = generalUtil.getElementText(dectHeader);
		return Text;
	}

	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}

	public String verifyDeductionFontType() {
		String fontType = generalUtil.getFontType(deductionTab);
		return fontType;
	}

	public void clickHomeTab() {
		homeTab.click();
	}

	public String verifyReturnHomePageFunction() {
		String Text = generalUtil.getElementText(homePageHeader);
		return Text;
	}

	public void clickAddDeductionTab() {
		addDeductionTab.click();
	}

	public void clickWorkersDropDown() {
		workersDropDownOption.click();
	}

	public void clickDennisBenny() {
		dennisBennyOption.click();
	}

	public void clickTitleDropDown() {
		titleDropDownOption.click();

	}

	public void clickBootsOption() {
		BootsOption.click();
	}

	public void enterAmount(String Amount) {
		amount.sendKeys(Amount);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public String verifyAddDeductionFunction() {
		String Text = generalUtil.getElementText(addedDeductionPageHeader);
		return Text;
	}

}
