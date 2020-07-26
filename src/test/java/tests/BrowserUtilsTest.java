package tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.BrowserUtilities;
import utilities.Driver;

public class BrowserUtilsTest {



	
	@Test
	public void test1() throws InterruptedException {
		
		Driver.getDriver().get("https://www.dice.com/");
		Thread.sleep(3000);
		Driver.getDriver().findElement(
				By.xpath("//input[@placeholder='Job title, skills or company']")).sendKeys("Automation Engineer"+Keys.ENTER);
//		
		Thread.sleep(2000);
		List<WebElement> links = Driver.getDriver().findElements(By.xpath("//div[@id='searchDisplay-div']//a[@class='card-title-link bold']"));
		
		System.out.println(links.size());
		for (int i = 0; i < links.size(); ) {
			links.get(i).click();
			Thread.sleep(2000);
			Driver.getDriver().navigate().back();
			Thread.sleep(2000);
			links = Driver.getDriver().findElements(By.xpath("//div[@id='searchDisplay-div']//a[@class='card-title-link bold']"));
			System.out.println(links.size());
		}
		
			
		
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
