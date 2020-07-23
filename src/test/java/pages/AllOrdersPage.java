package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AllOrdersPage extends BasePage {
	
	
	
	
	
	
	
	@FindBy (xpath = "//ul[@id='ctl00_menu']//li")
	public List<WebElement> list;
	
	
	
	@FindBy (id = "ctl00_MainContent_btnCheckAll")
	public WebElement checkAllButton;
	
	@FindBy (className = "btnDeleteSelected")
	public WebElement deleteButton;
	
	@FindBy (id = "ctl00_MainContent_orderMessage")
	public WebElement message;
	
	
	
	
	
	
	
	

}
