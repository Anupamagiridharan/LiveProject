package execute;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRespostiory.HomePage;
import elementRespostiory.LoginPage;

public class ExecuteHome extends BaseClass {
	LoginPage login;
	HomePage home;

	@Test
	public void testCase01verifyLogOutFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		home = new HomePage(driver);
		home.clickCarolThomasTab();
		home.clickLogOutOption();
		String expectedText = "Login";
		Assert.assertEquals(expectedText, home.verifyLogOutFunction());

	}
	
	@Test
	public void testCase02verifySettingTabFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		home = new HomePage(driver);
		home.clickSetting();
		String expectedText = "FORBIDDEN (#403)";
		Assert.assertEquals(expectedText, home.verifySettingFunction());

	}
	

	@Test
	public void testCase03verifylogoFontSize() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		home = new HomePage(driver);
		String expectedbgColor = "400";
		Assert.assertEquals(expectedbgColor, home.verifyLogoFontSize());

	}
}
