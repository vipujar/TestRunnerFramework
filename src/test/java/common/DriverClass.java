package common;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import core.InitBrowser;
import utils.readLocators;


public class DriverClass {
	public WebDriver driver;
	public Properties Locator;
	@BeforeClass
	@Parameters({"browser"}) 
	public void getBrowser(String browser) {
		InitBrowser init=new InitBrowser();
		init.initMethod(browser);
		driver=init.getDriver();
		readLocators loc=new  readLocators();
		Locator=readLocators.mergedProperties;
		Reporter.log(browser +" Vishwa");
	}
	
}

