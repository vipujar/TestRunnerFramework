package core;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

import listerners.DriverListerner;

public class InitBrowser{
	private  WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	Logger logger
    = Logger.getLogger(InitBrowser.class.getName());

	public void initMethod(String browser){
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\vbp20\\Downloads\\chromedriver_win321"+ File.separator +"chromedriver.exe");
			// To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
			// Stability and security will suffer."
			// Add an argument 'test-type'
			DesiredCapabilities capabilities = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--headless", "window-size=1280,1024", "--no-sandbox"); // Enable for headless option
//			capabilities.setCapability("chrome.binary",System.getProperty("user.dir")+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 WebDriverListener listener = new DriverListerner();
			    
			WebDriver original = new ChromeDriver(options);
			driver = new EventFiringDecorator(listener).decorate(original);
			
		}
		if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
	}
	
	

}
