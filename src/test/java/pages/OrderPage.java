package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.Driver;

public class OrderPage extends BasePage {
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement selectBox;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement pricePerUnit;

	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement discount;

	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement totalPrice;

	
	@FindBy (xpath = "//input[@value='Calculate']")
	public WebElement calculateButton;
	
	
	public void selectProduct(String product) {
		Select s = new Select(selectBox);
		
		s.selectByVisibleText(product);
		
	}
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement name;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;

	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;

	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement state;

	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	
	public void clickOnCheckBox(String card) {
		for (WebElement checkbox : Driver.getDriver().findElements(By.xpath("//input[@type='radio']"))) {
			if(checkbox.getAttribute("value").equals(card)) {
				checkbox.click();
			}
		}
	}
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNo;
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expiry;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processButton;
	
	
	@FindBy (tagName =  "strong")
	public WebElement successText;
	
	
	
	
	
	
	
	


	
	
	

	
	

}
