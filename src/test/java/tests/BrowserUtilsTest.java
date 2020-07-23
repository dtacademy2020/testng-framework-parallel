package tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import utilities.BrowserUtilities;
import utilities.Driver;

public class BrowserUtilsTest {



	
	@Test
	public void test1() {
		
		Driver.getDriver().get("https://www.lexus.com/");
		
		assertTrue(false);
//		
		
	}
	
	
	@Test
	public void fileUploadTest() {
		
		Driver.getDriver().get("http://tinyupload.com/");
		Driver.getDriver().findElement(By.xpath("//input[@name='uploaded_file']")).
		sendKeys("C:\\Users\\Duotech\\git\\FrameworkNew\\pom.xml");
		
		Driver.getDriver().findElement(By.xpath("//img[@alt='Upload']")).click();
		
//		
		
	}
	
	
	@Test
	public void fileDownloadTest() {
		
	//	logger = reporter.createTest("Testing entire page screenshot");
		Driver.getDriver().get("https://www.pexels.com/");
		Driver.getDriver().findElement(By.xpath("//a[@data-photo-id='1494280']")).
		click();
		
		
		
//		
		
	}
	
}
