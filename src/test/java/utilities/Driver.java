package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private static final ThreadLocal<WebDriver> drivers =  new ThreadLocal<>(); // also called driverPool
	
	private Driver() {};
	
	
	public static synchronized WebDriver getDriver(String browser) {
		
		if(drivers.get() == null ) {
			
			if(browser == null) {
				browser=ConfigReader.getProperty("browser");
			}
			
			switch(browser) {
			
			
			case "chrome":

				WebDriverManager.chromedriver().setup();
				drivers.set(new ChromeDriver());
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				drivers.set(new FirefoxDriver());
				break;
				
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				drivers.set( new EdgeDriver());
				break;
				
			case "opera":
				WebDriverManager.operadriver().setup();
				drivers.set(new OperaDriver());
				break;
			
			case "ie":
				WebDriverManager.iedriver().setup();
				drivers.set(new InternetExplorerDriver());
				break;
			case "headlessChrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); // -> extra setting required for Windows machines
				WebDriverManager.chromedriver().setup();
				drivers.set(new ChromeDriver(options));
				break;
				
			case "headlessFirefox":
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addArguments("--headless");
				WebDriverManager.firefoxdriver().setup();
				drivers.set(new FirefoxDriver(foptions));
				break;
			case "phantomJS":	
				WebDriverManager.phantomjs().setup();
				drivers.set(new PhantomJSDriver());
				break;
			case "htmlUnit":	
				drivers.set(new HtmlUnitDriver(true)); //-> true enables JavaScript
				break;

								
			}
			
			
			
			
			
		}
		
		return drivers.get();
		
				
		
	}
	
	public static WebDriver getDriver() {
		return getDriver(null);
	}

	
	public static synchronized void quit() {
		if(drivers.get() != null) {
			drivers.get().quit();
			drivers.remove();
		}
		
	}
	
	
	
	
	
	

}
