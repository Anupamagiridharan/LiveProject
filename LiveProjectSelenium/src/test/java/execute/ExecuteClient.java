package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.ClientPage;
import elementRespostiory.LoginPage;

public class ExecuteClient extends BaseClass {
	LoginPage login;
	ClientPage client;

	@Test
	public void testCase01verifyClientHeaderHighlighted() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		client = new ClientPage(driver);
		client.clickClientab();
		client.verifyClientHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(client.verifyClientHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase02verifyClientTabOuterHtml() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		client = new ClientPage(driver);
		client.clickClientab();
		client.verifyouterHtmlofclienrTab();
		String expectedHtml = "<a href=\"/payrollapp/client/index\">Clients</a>";
		Assert.assertEquals(expectedHtml, client.verifyouterHtmlofclienrTab());

	}

	@Test
	public void testCase03searchButtonfunctionalityWithInvalidDetails() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		client = new ClientPage(driver);
		client.clickClientab();
		client.enterClientName("dqs");
		client.enterClientId("1");
		client.clickSearchbBtn();
		String expectedID = "No results found.";
		Assert.assertEquals(expectedID, client.verifyinvalidDetailsSearchFunctionality());

	}

	@Test
	public void testCase03searchButtonfunctionalityWithvalidDetails() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		client = new ClientPage(driver);
		client.clickClientab();
		client.enterClientName("kuttu");
		client.enterClientId("2");
		client.clickSearchbBtn();
		String expectedName = "Kuttu";
		Assert.assertEquals(expectedName, client.verifyvalidDetailsSearchFunctionality());

	}

	@Test
	public void testCase03resetButtonfunctionalityWithvalidDetails() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		client = new ClientPage(driver);
		client.clickClientab();
		client.enterClientName("kuttu");
		client.enterClientId("2");
		client.clickResetBtn();
		String expectedName = "";
		Assert.assertEquals(expectedName, client.verifyResetFunctionality());
	}
}