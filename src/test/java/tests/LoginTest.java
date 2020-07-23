package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.BrowserUtilities;
import utilities.ConfigReader;


public class LoginTest extends TestBase {
	
	
	@Test (groups ="smoke")
	public void positiveLogin() {
		logger = reporter.createTest("Positive login using POM") ;

		logger.info("Entering username");

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		logger.info("Entering password and hit enter");

		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test" + Keys.ENTER);
		logger.info("verifying the title");

		assertEquals(driver.getTitle(), "Web Orders");
	}
	
	
	
	@Test
	public void positiveLoginUsingPOM() throws IOException {
		logger = reporter.createTest("Positive login using POM") ;

		LoginPage loginPage = new LoginPage();
		logger.info("Entering username");
		loginPage.usernameField.sendKeys(ConfigReader.getProperty("username"));
		logger.info("Entering password");
		loginPage.passwordField.sendKeys(ConfigReader.getProperty("password"));
		logger.info("Clicking login");
		loginPage.loginButton.click();
		
		logger.info("verifying the title");

		assertEquals(driver.getTitle(), "Web Orderz");
		
		
		
	}
	
	
	@Test (groups ="smoke")
	public void positiveLoginUsingPOMwithMethods() {
		logger = reporter.createTest("Positive login using POM with methods ") ;
		
		LoginPage loginPage = new LoginPage();
		
		logger.info("Logging in");
		
		loginPage.login();
		
		logger.info("verifying the title");

		assertEquals(driver.getTitle(), "WeV Orders");
		
		
		//BDD STYLE TEST CASE
		//Given the user is at Login page
		//When user enters username and password
		//Then user should be able to login
		
	}

}
