package module1;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	Logger logger= Logger.getLogger(TestCase1.class.getName());
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{2, 3 , 5}, {5, 7, 12}};
	}
	
      @Test (dataProvider = "data-provider")
      public void myTest (int a, int b, int result) {
	     int sum = a + b;
	     Assert.assertEquals(result, sum);
	    
      }
      @Test
	public void test1(){
    	  WebDriver driver;
    
    	  WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();
			 driver = wdm.create();
		driver.get("https://github.com/");
		//logger.info(Locator.getProperty("twitter.login.username.xpath"));
		driver.close();
		
	}

}
