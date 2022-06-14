package module1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;


import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.DriverClass;

public class TestCase1 extends DriverClass {
	Logger logger= Logger.getLogger(TestCase1.class.getName());
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
	}
	
      @Test (dataProvider = "data-provider")
      public void myTest (int a, int b, int result) {
	     int sum = a + b;
	     Assert.assertEquals(result, sum);
	    
      }
      @Test
	public void test1(){

		driver.get("https://github.com/");
		logger.info(Locator.getProperty("twitter.login.username.xpath"));
		driver.close();
		
	}

}
