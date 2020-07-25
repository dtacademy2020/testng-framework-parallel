package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;

public class PlaceOrderTest extends TestBase {

	@BeforeMethod(alwaysRun = true)
	public void setupOrdersPage() {
		new LoginPage().login();
	}

	@Test(enabled = false)
	public void productInfoTest() {

		OrderPage op = new OrderPage();

		op.OrderPageLink.click();

		op.selectProduct("MyMoney");

		op.quantity.sendKeys("2");

		op.calculateButton.click();

		String actualPrice = op.pricePerUnit.getAttribute("value");
		String expectedPrice = "100";
		assertEquals(actualPrice, expectedPrice);

		String actualTotal = op.totalPrice.getAttribute("value");
		String expectedTotal = String.valueOf(Integer.parseInt(expectedPrice) * 2);
		assertEquals(actualTotal, expectedTotal);

	}

	@Test(dataProvider = "products")

	public void productInfoTestwithDP(String product, int price, int discount) {

		OrderPage op = new OrderPage();

		op.OrderPageLink.click();

		op.selectProduct(product);

		int quantity = 10;
		op.quantity.sendKeys(quantity + "");

		op.calculateButton.click();

		int actualPrice = Integer.parseInt(op.pricePerUnit.getAttribute("value"));
		int expectedPrice = price;
		assertEquals(actualPrice, expectedPrice);

		String actualDiscount = op.discount.getAttribute("value");
		String expectedDiscount = String.valueOf(discount);
		assertEquals(actualDiscount, expectedDiscount);

		String actualTotal = op.totalPrice.getAttribute("value");
		String expectedTotal = String.valueOf((expectedPrice * quantity * (100 - discount) / 100));
		assertEquals(actualTotal, expectedTotal);

	}

	@Test
	public void verifyOrderDetails() throws InterruptedException {
		OrderPage op = new OrderPage();

		op.OrderPageLink.click();

		op.selectProduct("MyMoney");

		int quantity = 2;
		op.quantity.sendKeys(quantity + "");

		op.calculateButton.click();

		Faker f = new Faker();

		String expectedName = f.name().fullName();
		op.name.sendKeys(expectedName);
		op.street.sendKeys(f.address().streetAddress());
		op.city.sendKeys(f.address().city());
		op.state.sendKeys(f.address().state());
		op.zip.sendKeys(f.address().zipCode().substring(0, 5));

		op.clickOnCheckBox("Visa");
		op.cardNo.sendKeys(f.finance().creditCard(CreditCardType.VISA).replaceAll("-", ""));
		op.expiry.sendKeys("07/23");
		op.processButton.click();

		Thread.sleep(2000);

		assertTrue(op.successText.getText().contains("New order has been successfully added."));

		op.allOrdersPageLink.click();

		String actualName = new AllOrdersPage().getCellText(1, 1);
		System.out.println(actualName);

		assertEquals(actualName, expectedName);

	}
	
	
	@Test (dataProvider = "customers")
	public void verifyOrderDetailsDP(String name, String address, String city, String state, String zip, String cardNo) throws InterruptedException {
		OrderPage op = new OrderPage();

		op.OrderPageLink.click();

		op.selectProduct("MyMoney");

		int quantity = 2;
		op.quantity.sendKeys(quantity + "");

		op.calculateButton.click();

		

		String expectedName = name;
		op.name.sendKeys(expectedName);
		String expectedAddress = address;
		op.street.sendKeys(expectedAddress);
		op.city.sendKeys(city);
		op.state.sendKeys(state);
		op.zip.sendKeys(zip);

		op.clickOnCheckBox("Visa");
		op.cardNo.sendKeys(cardNo);
		op.expiry.sendKeys("07/23");
		op.processButton.click();

		

		assertTrue(op.successText.getText().contains("New order has been successfully added."));

		op.allOrdersPageLink.click();

		String actualName = new AllOrdersPage().getCellText(1, 1);
		System.out.println(actualName);
		
		String actualAddress = new AllOrdersPage().getCellText(1, 5);
		System.out.println(actualAddress);

		
		
		assertEquals(actualName, name);
		assertEquals(actualAddress, address);

	}

	
	
	

	@DataProvider (name = "products", parallel = true) //parallel = true -> will enable the test that uses this
														//Dataprovider to run in parallel
	
	public Object[][] get(){
		
		return new Object[][] {
			
			{"MyMoney", 100, 8},
			{"FamilyAlbum", 80, 15},	
			{"ScreenSaver", 20,10}
			
				
			
			
		};
		
	}

	@DataProvider (name = "customers", parallel = true) //parallel = true -> will enable the test that uses this
	//Dataprovider to run in parallel

		public Object[][] getData(){
		
		return new Object[][] {
		
		
		{"Tracy Jumel","6 International Point","Norfolk","Virginia","23514","3573624047365331"},
		{"Irina Allchorne","8 Fairfield Court","Columbia","South Carolina","29220","5207434199975740"}
		
		
		
		};

}

}
