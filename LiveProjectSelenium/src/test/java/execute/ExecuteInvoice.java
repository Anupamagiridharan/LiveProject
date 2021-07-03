package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.InvoicePage;
import elementRespostiory.LoginPage;

public class ExecuteInvoice extends BaseClass {
	LoginPage login;
	InvoicePage voice;

	@Test
	public void testCase01verifyInvoiceFunctionalityTab() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		voice = new InvoicePage(driver);
		voice.inVoiceTab();
		voice.verifyinVoiceHeader();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(voice.verifyinVoiceHeader());
		softAssert.assertAll();
	}

	@Test
	public void testCase02verifypdfFunctionality() {
		login = new LoginPage(driver);
		login.enterUserName("carol");
		login.enterPassword("1q2w3e4r");
		login.clickLoginBtn();
		voice = new InvoicePage(driver);
		voice.inVoiceTab();
		;
		voice.callElementTobeClickableExplicitWait(10);
		voice.pdfOption();
		String expectedText = "INVOICE";
		Assert.assertEquals(expectedText, voice.verifyPaySlipPdfPageHeading());

	}
}
