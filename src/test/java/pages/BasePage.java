package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.Driver;

public class BasePage {
	
	
	
 public BasePage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}
 
 
 
 	@FindBy (xpath = "//a[.='View all products']")
	public WebElement productPageLink;
 	
 	 	
 	@FindBy (xpath = "//a[.='View all orders']")
	public WebElement allOrdersPageLink;
 	
 	@FindBy (xpath = "//a[.='Order']")
	public WebElement OrderPageLink;
 	
 	
 	
 	@FindBy (css = ".login_info")
	public WebElement userNameHeader;
 	
 	
 	@FindBy (id = "ctl00_logout")
	public WebElement logOutLink;
 	
 	
 	public void logOut() {
 		BrowserUtilities.waitForVisibility(logOutLink, 2);
 		logOutLink.click();
 	}
 	
  

}
