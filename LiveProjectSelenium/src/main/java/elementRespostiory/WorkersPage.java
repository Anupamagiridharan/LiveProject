package elementRespostiory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExcelRead;
import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class WorkersPage {
	WebDriver driver;
	GeneralUtility generalUtil = new GeneralUtility();
	ExcelRead read = new ExcelRead();
	ExcelRead excel;
	ExplictWait explicit = new ExplictWait();

	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workersTab;
	@FindBy(xpath = "//ul[@id='w3']//li[4]")
	WebElement workersHeader;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[8]/a[2]")
	WebElement editOption;
	@FindBy(xpath = "/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement UpdateText;
	@FindBy(xpath = "//a[@href='/payrollapp/worker/create']")
	WebElement createWorkersOption;
	@FindBy(xpath = "//input[@id='workersearch-first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='workersearch-last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='workersearch-postcode']")
	WebElement pinCode;
	@FindBy(xpath = "//input[@id='workersearch-ni_number']")
	WebElement NiNum;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchBtn;
	@FindBy(xpath = "//div[@class='empty']")
	WebElement noResultText;
	@FindBy(xpath = "//select[@id='worker-title']")
	WebElement workersDropDown;
	@FindBy(xpath = "//select[@id='worker-title']//option[2]")
	WebElement dropDownText;
	@FindBy(xpath = "//h1[text()='Update Worker: Amal Xaviour']")
	WebElement updateHeading;
	@FindBy(xpath = "//span[@class='input-group-addon kv-date-calendar']")
	WebElement dateOfBirth;
	@FindBy(xpath = "//input[@class='form-control krajee-datepicker']")
	WebElement dateOfBirthText;
	
	public WorkersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickWorkerstab() {
		workersTab.click();
	}

	public boolean verifyWorkersHeader() {
		boolean clientAttbutValue = generalUtil.getAttributeValue(workersHeader, "class", "active");
		return clientAttbutValue;
	}

	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}

	public void clickUpdateOption() {
		editOption.click();
	}

	public String verifyeditPageHeaderText() {
		String updateText = generalUtil.getElementText(UpdateText);
		return updateText;

	}

	public void clickcreateWorkersoption() {
		createWorkersOption.click();
	}

	public void clickDateOfBirth() {
		dateOfBirth.click();
	}

	public void selectctTitleDropDown() {
		generalUtil.dropDownActionByVisibleText(workersDropDown, "Mr");

	}

	public String verifyDropDownText() {
		String Text = generalUtil.getElementText(dropDownText);
		return Text;
	}

	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}

	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}

	public void enterPinCode(String PinCode) {
		pinCode.sendKeys(PinCode);
	}

	public void enterNiNumber(String NiNumber) {
		NiNum.sendKeys(NiNumber);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void excelLogin() {
		firstName.sendKeys(excel.getinputFromExcel(0, 1, 0));
		lastName.sendKeys(excel.getinputFromExcel(0, 1, 1));
		pinCode.sendKeys(excel.getinputFromExcel(0, 1, 2));
		NiNum.sendKeys(excel.getinputFromExcel(0, 1, 3));
		searchBtn.click();

	}

	public String verifyinValidText() {
		String inValidText = generalUtil.getElementText(noResultText);
		return inValidText;
	}

	public void dynamicLocatorEdit(String editIcon) {
		// TODO Auto-generated method stub

		String path = "//table[@class='table table-striped table-bordered']//tr//td[1]";
		List<String> textValuesofRow = new ArrayList<String>();
		textValuesofRow = generalUtil.dynamicLocator(driver, path);
		for (int j = 0; j < textValuesofRow.size(); j++) {
			if (textValuesofRow.get(j).contentEquals(editIcon)) {
				j = j + 1;
				String expectedLocator = "//table[@class='table table-striped table-bordered']//tr[" + j
						+ "]//td[8]//a[2]";
				WebElement locatorElement = driver.findElement(By.xpath(expectedLocator));
				locatorElement.click();
			}

		}
	}

	public String verifyUpdatePageHeaderText() {
		String updateText = generalUtil.getElementText(updateHeading);
		return updateText;
	}

	public void selectDateFromDatePicker() {
		dateOfBirth.click();
		String expectedDate = "October 2021";
		while (true) {
			String currentDate = "(//table[@class='table-condensed']//tr[2]//th[2])[1]";
			WebElement currentDateElement = driver.findElement(By.xpath(currentDate));
			String currentDateText = generalUtil.getElementText(currentDateElement);
			if (currentDateText.equals(expectedDate)) {
				break;
			} else {
				WebElement nextButtonDatePicker = driver.findElement(By.xpath("(//table[@class='table-condensed']//tr[2]//th[3])[1]"));
				nextButtonDatePicker.click();
			}
		}
		WebElement actualDate = driver.findElement(By.xpath("//table[@class='table-condensed']//tr[2]//td[4]"));
		actualDate.click();
	}
	public String verifyDateOfBirth() {
		String Text = generalUtil.getElementText(dateOfBirthText);
		return Text;
	}

}