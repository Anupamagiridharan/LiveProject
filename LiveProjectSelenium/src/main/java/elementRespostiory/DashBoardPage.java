package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();
	ExplictWait explicit = new ExplictWait();

	@FindBy(xpath = "//a[text()='Dashboard']")
	WebElement dashBoardTab;

	@FindBy(xpath = "//ul[@id='w1']//li[1]")
	WebElement DashBoardHeading;

	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement payRollText;

	public DashBoardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDashBoardTab() {
		dashBoardTab.click();
	}

	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}

	public boolean verifyDashBoardHeader() {
		boolean timeAttbutValue = generalUtil.getAttributeValue(DashBoardHeading, "class", "active");
		return timeAttbutValue;
	}

	public void getPageTitle() {
		generalUtil.getPagTitle(driver, payRollText);
	}
}
