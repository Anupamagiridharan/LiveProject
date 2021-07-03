package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.DashBoardPage;
import elementRespostiory.LoginPage;

public class executeDashBoard extends BaseClass {
	LoginPage login;
	DashBoardPage dash;

	@Test
	public void testCase01verifyDashBoardHeaderHighlighted() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dash = new DashBoardPage(driver);
		dash.clickDashBoardTab();
		dash.verifyDashBoardHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dash.verifyDashBoardHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase02VerifyDashBoardTitle() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		dash = new DashBoardPage(driver);
		dash.clickDashBoardTab();
		dash.getPageTitle();
		String expectedTitle = "Payroll Application";
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}
}
