package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.LoginPage;
import utilityClass.ExcelRead;

public class ExecuteLogin extends BaseClass {

	LoginPage login;

	@Test
	public void testCase01VerifyrememberMeCheckbox() {
		login = new LoginPage(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(login.selectrememberMeCheckbox());
		softAssert.assertAll();
	}

	@Test
	public void testCase02VerifyresetitLink() {
		login = new LoginPage(driver);
		String expectedTag = "a";
		Assert.assertEquals(expectedTag, login.verifyResetitLink());
	}

	@Test
	public void testCase03VerifyInValidLoginFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("car");
		login.enterPassword("1q2w");
		login.clickLoginBtn();
		String expectedMsg = "Incorrect username or password.";
		Assert.assertEquals(expectedMsg, login.verifyInvalidLoginMessage());
	}

	@Test
	public void testCase04VerifyValidLoginFunctionality() {
		login = new LoginPage(driver);
		ExcelRead excel = new ExcelRead();
		String userName = excel.getinputFromExcel(0, 0, 0);
		String passWord = excel.getinputFromExcel(0, 0, 1);
		login.enterUserName(userName);
		login.enterPassword(passWord);
		login.clickLoginBtn();
		String expectedUser = "CAROL THOMAS";
		Assert.assertEquals(expectedUser, login.verifyLogin());
	}

}
