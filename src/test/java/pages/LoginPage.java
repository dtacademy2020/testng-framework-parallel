package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {
	
	public LoginPage() {
		
		PageFactory.initElements(Driver.getDriver(), this); // This statement is initializing the variables that are tagged
															//with @FindBy annotations
		
	}
	
	
	
	
	@FindBy (name = "ctl00$MainContent$username")
	public WebElement usernameField;
	
	
	
	@FindBy (id = "ctl00_MainContent_password")
	public WebElement passwordField;
	
	
	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup 
	public WebElement loginButton;
	
	
	public String title = Driver.getDriver().getTitle();
	
	
	public void login() {
		usernameField.sendKeys(ConfigReader.getProperty("username"));
		passwordField.sendKeys(ConfigReader.getProperty("password"));
		loginButton.click();
	}
	
//	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
//	public WebElement loginButton;
	

}
