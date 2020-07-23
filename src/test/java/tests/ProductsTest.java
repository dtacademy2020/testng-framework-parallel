package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.AllOrdersPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends TestBase{
	
	@Test (groups ="smoke")
	public void verifyProductNames() {
	logger = reporter.createTest("Verify product names");

	LoginPage lp = new LoginPage();
	
	logger.info("Logging in");
	
	lp.login();
	
	AllOrdersPage ap = new AllOrdersPage();
	logger.info("Clicking on products link");

	
	ap.productPageLink.click();
	
	ProductsPage pp = new ProductsPage();
	
	List<String> expected = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
	List<String> actual = new ArrayList<String>();
	
	for (WebElement el : pp.list) {
		actual.add(el.getText());
		
	}
	logger.info("Verifying the product names");

	assertEquals(actual, expected);
	
	
	
		
		
		
	}

}
