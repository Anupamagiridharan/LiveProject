package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class TimeSheetPage {

	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();
	ExplictWait explicit = new ExplictWait();

	@FindBy(xpath = "//a[text()='TimeSheet']")
	WebElement timeSheetTab;
	@FindBy(xpath = "//ul[@id='w1']//li[6]")
	WebElement timeSheetHeader;
	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/create']")
	WebElement createTimeSheet;
	@FindBy(xpath = "//button[text()='Skip']")
	WebElement skipButton;
	@FindBy(xpath = "//div[@class='col-lg-2 col-sm-4 left-menu no-padding']//li[3]")
	WebElement createTimeSheetHeader;
	@FindBy(xpath = "//a[@ href='/payrollapp/timesheet/approvedlist']")
	WebElement approvedPaySlip;
	@FindBy(xpath = "//*[@id=\"grid\"]/table/thead/tr/th[5]")
	WebElement approvalStatus;
	@FindBy(xpath = "//button[text()='Generate Playslip']")
	WebElement generatepaySlipBtn;
	@FindBy(xpath = "//button[text()='Generate Invoice']")
	WebElement generateInvoiceBtn;
	@FindBy(xpath = "//h1[text()='Timesheets']")
	WebElement timeSheetHeading;

	public TimeSheetPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickTimeSheetTab() {
		timeSheetTab.click();
	}

	public boolean verifyTimeSheetHeader() {
		boolean timeAttbutValue = generalUtil.getAttributeValue(timeSheetHeader, "class", "active");
		return timeAttbutValue;
	}

	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}

	public void clickApprovedPaySlipOption() {
		approvedPaySlip.click();
	}

	public String verifyApprovedPaySlip() {
		String Text = generalUtil.getElementText(approvalStatus);
		return Text;
	}

	public void callElementTobeClickableExplicitWait(long time) {
		explicit.elementClickablexplicitWait(createTimeSheet, driver, 10);
	}

	public void clickCreateTimeSheet() {
		createTimeSheet.click();
	}

	public void clickSkipBtn() {
		skipButton.click();
	}

	public boolean verifyCreateTimeSheetHeader() {
		boolean createAttbutValue = generalUtil.getAttributeValue(createTimeSheetHeader, "class", "active");
		return createAttbutValue;
	}

	public void clickgeneratePaySlip() {
		generatepaySlipBtn.click();
	}

	public void callAlertAccept() {
		generalUtil.AlertacceptControl(driver);
	}

	public void clickgenerateinvoice() {
		generateInvoiceBtn.click();
	}

	public void callAlertdismiss() {
		generalUtil.AlertacceptControl(driver);
	}

	public String verifyPageHeading() {
		String Text = generalUtil.getElementText(timeSheetHeading);
		return Text;
	}
}