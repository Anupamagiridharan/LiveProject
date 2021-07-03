package execute;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRespostiory.DeductionPage;
import elementRespostiory.LoginPage;

public class ExecuteDeduction extends BaseClass {
	LoginPage login;
	DeductionPage dect;

	@Test
	public void testCase01verifyDeductionFunctionalityTab() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dect = new DeductionPage(driver);
		dect.clickDeductiontab();
		dect.verifyDeductionHeader();
		String expectedText = "Deduction";
		Assert.assertEquals(expectedText, dect.verifyDeductionHeader());
	}

	@Test
	public void testCase02verifyDeductionTabFontType() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dect = new DeductionPage(driver);
		dect.clickDeductiontab();
		dect.verifyDeductionFontType();
		String expectedText = "600";
		Assert.assertEquals(expectedText, dect.verifyDeductionFontType());
	}

	@Test
	public void testCase03verifyReturnHomePageFunctioality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dect = new DeductionPage(driver);
		dect.clickDeductiontab();
		dect.clickHomeTab();
		dect.verifyReturnHomePageFunction();
		String expectedText = "PAYROLL APPLICATION";
		Assert.assertEquals(expectedText, dect.verifyReturnHomePageFunction());
	}

	@Test
	public void testCase04verifyAddDeductionFunctioality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dect = new DeductionPage(driver);
		dect.clickDeductiontab();
		dect.clickAddDeductionTab();
		dect.clickWorkersDropDown();
		dect.clickDennisBenny();
		dect.clickTitleDropDown();
		dect.clickBootsOption();
		dect.enterAmount("800");
		dect.clickSaveBtn();
		dect.verifyAddDeductionFunction();
		String expectedText = "Dennis";
		Assert.assertEquals(expectedText, dect.verifyAddDeductionFunction());
	}
}
