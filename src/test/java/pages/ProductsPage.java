package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class ProductsPage extends BasePage{

	
	
	@FindBy (xpath = "//table[@class='ProductsTable']//tr//td[1]")
	public List<WebElement> list;
	
	

}
