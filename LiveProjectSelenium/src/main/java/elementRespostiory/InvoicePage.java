package elementRespostiory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.ExplictWait;
import utilityClass.GeneralUtility;

public class InvoicePage {
	WebDriver driver;
	GeneralUtility generalUtil=new GeneralUtility();
	ExplictWait explicit=new ExplictWait();
	@FindBy(xpath="//a[text()='Invoice']")
	 WebElement inVoice;
	@FindBy(xpath="//ul[@id='w2']//li[8]")
	 WebElement inVoiceHeader;
	@FindBy(xpath="//a[@href='/payrollapp/invoice/generate?id=1218']//span[@class='glyphicon glyphicon-paperclip']")
	 WebElement pdfOption;
	@FindBy(xpath="//*[@id=\"title\"]")
	 WebElement inVoicePdfPage;
	@FindBy(xpath="//h1[text()='Invoice']")
	 WebElement inVoicePdfPageHeading;
	
	public InvoicePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	public void inVoiceTab(){
		inVoice.click();
		}
	public boolean verifyinVoiceHeader() {
		boolean voiceAttbutValue=generalUtil.getAttributeValue(inVoiceHeader, "class", "active");
		return voiceAttbutValue;
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
		 String Text=generalUtil.getElementText( inVoicePdfPageHeading);
		 return Text;
		}
	}


  

