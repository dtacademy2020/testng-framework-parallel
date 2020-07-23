package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AllOrdersPage;
import pages.LoginPage;
import utilities.BrowserUtilities;

public class OrdersInfoTest extends TestBase{
	
	AllOrdersPage ap;
	
	
	@BeforeMethod (alwaysRun = true)
	public void setupOrdersPage() {
		new LoginPage().login(); 
	}
	
	@Test (groups ="smoke")
	public void verifyLinks() {
		logger = reporter.createTest("Verify 3 links");

		
		ap = new AllOrdersPage();
		
		List<String> expectedList = Arrays.asList("View all orders", "View all products", "Order");
		
//		
		logger.log(Status.INFO, "Retrieving text of the links");

		List<String> actualList = BrowserUtilities.getElementsText(ap.list);
		
		logger.info("Verifying that 2 lists are equal");

		assertEquals(actualList, expectedList);
		
		
		
	}
	
	@Test
	public void verifyDeleteAllButton() {
		logger = reporter.createTest("Verify delete all button");
		
		ap = new AllOrdersPage();
		
		
		
		logger.info("Clicking on check all button");
		ap.checkAllButton.click();
		logger.info("Clicking on delete button");
		ap.deleteButton.click();
		String expected = "List of orders is empty. In order to add new order use this link.";
		String actual = ap.message.getText();
		logger.info("Verifying the the expected message");
		assertEquals(actual, expected);
    	
		
	}

}
