package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.LoginPage;
import elementRespostiory.TimeSheetPage;

public class ExecuteTimeSheet extends BaseClass {
	LoginPage login;
	TimeSheetPage time;

	@Test
	public void testCase01verifyTimeSheetFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.verifyTimeSheetHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(time.verifyTimeSheetHeader());
	}

	@Test
	public void testCase02verifyGeneratePaySlipFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.clickApprovedPaySlipOption();
		String expectedStatus = "Approval Status";
		Assert.assertEquals(expectedStatus, time.verifyApprovedPaySlip());
	}

	@Test
	public void testCase03verifyCreateTimeSheetisClickable() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.callElementTobeClickableExplicitWait(10);
		time.clickCreateTimeSheet();
		time.verifyCreateTimeSheetHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(time.verifyCreateTimeSheetHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase04verifyCreateTimeSheetFunction() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.clickCreateTimeSheet();
		time.clickSkipBtn();
		time.callAlertAccept();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(time.verifyCreateTimeSheetHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase05ClickgeneratePaySlip() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.clickgeneratePaySlip();
		time.callAlertAccept();
		String expectedHeading = "TIMESHEETS";
		Assert.assertEquals(expectedHeading, time.verifyPageHeading());
	}

	@Test
	public void testCase06VerifygenerateinvoiceTab() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		time = new TimeSheetPage(driver);
		time.clickTimeSheetTab();
		time.clickgenerateinvoice();
		time.callAlertdismiss();
		String expectedStatus = "TIMESHEETS";
		Assert.assertEquals(expectedStatus, time.verifyPageHeading());
	}

}
