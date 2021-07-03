package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class ClientPage {
	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();
	ExplictWait explicit = new ExplictWait();

	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientTab;

	@FindBy(xpath = "//ul[@id='w3']//li[3]")
	WebElement clientTabHeading;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientTabhtml;

	@FindBy(xpath = "//h1[text()='Clients']")
	WebElement clientPageTitle;

	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientName;

	@FindBy(xpath = "//input[@id='clientsearch-id']")
	WebElement clientID;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='empty']")
	WebElement noResultFoundText;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[2]//td[2]")
	WebElement clientNameKuttu;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetBtn;

	public ClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickClientab() {
		clientTab.click();
	}

	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}

	public boolean verifyClientHeader() {
		boolean clientAttbutValue = generalUtil.getAttributeValue(clientTabHeading, "class", "active");
		return clientAttbutValue;
	}

	public String verifyouterHtmlofclienrTab() {
		String htmlCode = generalUtil.gethtml(clientTabhtml, "outerHTML");
		return htmlCode;
	}

	public void enterClientName(String name) {
		clientName.sendKeys(name);
	}

	public void enterClientId(String id) {
		clientID.sendKeys(id);
	}

	public void clickSearchbBtn() {
		searchBtn.click();
	}

	public String verifyinvalidDetailsSearchFunctionality() {
		String invalidText = generalUtil.getElementText(noResultFoundText);
		return invalidText;
	}

	public String verifyvalidDetailsSearchFunctionality() {
		String invalidText = generalUtil.getElementText(clientNameKuttu);
		return invalidText;
	}

	public void clickResetBtn() {
		resetBtn.click();
	}

	public String verifyResetFunctionality() {
		String Text = generalUtil.getElementText(clientName);
		return Text;
	}
}