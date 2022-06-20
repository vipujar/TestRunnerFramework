package core;

import java.util.logging.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

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
			 //WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\vbp20\\Downloads\\chromedriver_win321"+ File.separator +"chromedriver.exe");
			// To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
			// Stability and security will suffer."
			// Add an argument 'test-type'
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments( "window-size=1280,1024", "--no-sandbox","--headless"); // Enable for headless option
//			capabilities.setCapability("chrome.binary",System.getProperty("user.dir")+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
			WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker()
		            .enableVnc().enableRecording();
			 driver = wdm.create();
			
//			 WebDriverListener listener = new DriverListerner();
//			    
//			WebDriver original = new ChromeDriver(options);
//			driver = new EventFiringDecorator(listener).decorate(original);
			
		}
		if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
	}
	
	

}
