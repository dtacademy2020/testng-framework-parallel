package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase { // Abstraction example in my framework
	
	
	
protected WebDriver driver;
protected Actions actions;

protected static ExtentReports reporter; // Manages the whole reporting process
protected static ExtentSparkReporter htmlReporter; // Responsible for generating the HTML
protected static ExtentTest logger; // Responsible for logs -> diagnostic messages about the various stages of the test case

	@BeforeSuite (alwaysRun = true)
	public void setUpSuite() {
		reporter = new ExtentReports();
		
		String path = System.getProperty("user.dir")+"/test-output/ExtentReports/report.html";
		
		htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setReportName("Web Orders Automation Test Reports");
		
		reporter.attachReporter(htmlReporter);
		
		reporter.setSystemInfo("Tester", "John Doe");
		reporter.setSystemInfo("ENV", "Staging/Pre-Production");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getProperty("browser"));
		
	}



	
	@BeforeMethod (alwaysRun = true)
	@Parameters ("browser")
	public void setUpMethod(@Optional String browser) {
		
		driver = Driver.getDriver(browser);
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(
				Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
		
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDownMethod(ITestResult testResult) throws IOException {
		
		if (logger != null) {
			if (testResult.getStatus() == ITestResult.SUCCESS) {

				logger.pass("PASSED, test case: " + testResult.getName());
			} else if (testResult.getStatus() == ITestResult.SKIP) {
				logger.skip("SKIPPED, test case: " + testResult.getName());
				logger.skip(testResult.getThrowable());
			} else if (testResult.getStatus() == ITestResult.FAILURE) {
				logger.fail("FAILED, test result: " + testResult.getName());
				logger.fail(testResult.getThrowable());
				String path = BrowserUtilities.getFullScreenshot(testResult.getName()); //takes the screenshot of entire page
				logger.addScreenCaptureFromPath(path); // Attaches the screenshot image to the report
			} 
		}
		Driver.quit();
	}
	
	
	@AfterSuite (alwaysRun = true)
	
	public void tearDownSuite() {
		reporter.flush();
	}
	
	
	

}
