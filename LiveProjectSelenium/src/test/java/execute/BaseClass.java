package execute;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilityClass.GeneralUtility;
import utilityClass.ScreenshotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenshotCapture ob;
	GeneralUtility generalUtil=new GeneralUtility();
	@BeforeMethod
	@Parameters({"browser"})
	
	public void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\rose\\Downloads\\chromedriver_win32\\chromedriver.exe ");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
				driver.get("https://www.qabible.in/payrollapp/site/login");
				generalUtil.applyImplicitWait(driver, 10);
			}
	else if(browser.equalsIgnoreCase("fireFox")) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rose\\Downloads\\geckodriver-v0.29.1-win32\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
			driver.get("https://www.qabible.in/payrollapp/site/login");
			generalUtil.applyImplicitWait(driver, 10);

	}
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
			ob=new ScreenshotCapture();
			ob.takeScreenShotfailure(driver,iTestResult.getName());
		}
		driver.quit();
	}
}
