package execute;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRespostiory.LoginPage;
import elementRespostiory.PaySlipPage;

public class ExecutePaySlip extends BaseClass {
	LoginPage login;
	PaySlipPage pay;
	
	@Test
	  public void testCase01verifyPaySlipHeaderHighlighted() {
			login= new LoginPage(driver) ;
			login.enterUserName("carol");
			login.enterPassword("1q2w3e4r");
			login.clickLoginBtn();
			pay=new PaySlipPage(driver);
			pay.paySlipTab();
			pay.verifyPaySlipHeader();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertTrue(pay.verifyPaySlipHeader());
			softAssert.assertAll();
	}
  @Test
	  public void testCase02verifypdfFunctionalityTab() {
			login= new LoginPage(driver);
			login.enterUserName("carol");
			login.enterPassword("1q2w3e4r");
			login.clickLoginBtn();
			pay=new PaySlipPage(driver);
			pay.paySlipTab();
			pay.pdfOption();
			String expectedText="PAYSLIPS";
			Assert.assertEquals(expectedText, pay.verifyPaySlipPdfPageHeading());
  }
  
}