package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.LoginPage;
import elementRespostiory.WorkersPage;
import utilityClass.ExcelRead;

public class ExecuteWorkersPage extends BaseClass {
	LoginPage login;
	WorkersPage work;
	ExcelRead excel;

	@Test
	public void testCase01verifyWorkersTab() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.clickWorkerstab();
		work.verifyWorkersHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(work.verifyWorkersHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase02verifyeditOption() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.clickWorkerstab();
		work.clickUpdateOption();
		String expectedMsg = "UPDATE WORKER: AMAL XAVIOUR";
		Assert.assertEquals(expectedMsg, work.verifyeditPageHeaderText());
	}

	@Test
	public void testCase03CreateWorkersTitleDropDown() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.callImplicitWait(10);
		work.clickWorkerstab();
		work.callImplicitWait(10);
		work.clickcreateWorkersoption();
		work.callImplicitWait(10);
		work.selectctTitleDropDown();
		String expectedMsg = "Mr";
		work.callImplicitWait(10);
		Assert.assertEquals(expectedMsg, work.verifyDropDownText());
	}

	@Test
	public void testCase04searchWorkerBYinvalidDetails() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.clickWorkerstab();
		excel = new ExcelRead();
		String firstname = excel.getinputFromExcel(0, 1, 0);
		String Lastname = excel.getinputFromExcel(0, 1, 1);
		String pinCode = excel.getinputFromExcel(0, 1, 2);
		String NiNum = excel.getinputFromExcel(0, 1, 3);
		work.enterFirstName(firstname);
		work.enterLastName(Lastname);
		work.enterPinCode(pinCode);
		work.enterNiNumber(NiNum);
		work.clickSearchBtn();
		String expectedUser = "No results found.";
		Assert.assertEquals(expectedUser, work.verifyinValidText());
	}

	@Test
	public void testCase05DynamicCheck() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.clickWorkerstab();
		work.dynamicLocatorEdit("5");
		String expectedUser = "UPDATE WORKER: CORINA ELENA SLUJITORU";
		Assert.assertEquals(expectedUser, work.verifyUpdatePageHeaderText());
	}

	@Test
	public void testCase06selectDateFromDatePicker() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		work = new WorkersPage(driver);
		work.clickWorkerstab();
		work.clickcreateWorkersoption();
		work.clickDateOfBirth();
		work.selectDateFromDatePicker();
		String expectedUser = "05-10-2021";
		Assert.assertEquals(expectedUser, work.verifyDateOfBirth());
	}
}
