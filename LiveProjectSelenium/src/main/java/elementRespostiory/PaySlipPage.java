package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class PaySlipPage {
	WebDriver driver;
	GeneralUtility generalUtil=new GeneralUtility();
	ExplictWait explicit=new ExplictWait();
	@FindBy(xpath="//a[text()='Payslip']")
	 WebElement paySlip;
	@FindBy(xpath="//ul[@id='w2']//li[7]")
	 WebElement payHeader;
	@FindBy(xpath="//a[@href='/payrollapp/payslip/pdf?id=2781']//span[@class='glyphicon glyphicon-paperclip']")
	 WebElement pdfOption;
	@FindBy(xpath="//*[@id=\"title\"]")
	 WebElement paySlipPdfPage;
	@FindBy(xpath="//h1[text()='Payslips']")
	 WebElement paySlipPdfPageHeading;
	
	public PaySlipPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	public void paySlipTab(){
		paySlip.click();
		}
	public boolean verifyPaySlipHeader() {
		boolean payAttbutValue=generalUtil.getAttributeValue(payHeader, "class", "active");
		return payAttbutValue;
	}
	
	public void callImplicitWait(long time) {
		generalUtil.applyImplicitWait(driver, 10);
	}
	public void callElementTobeClickableExplicitWait(long time) {
		explicit.elementClickablexplicitWait(pdfOption, driver, 10);
		}
	public void pdfOption(){
		pdfOption.click();
		}
	
	public String verifyPaySlipPdfPageHeading() {
		 String Text=generalUtil.getElementText(paySlipPdfPageHeading);
		 return Text;
		}
}
