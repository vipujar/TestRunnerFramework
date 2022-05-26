package module1;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import common.DriverClass;

public class TestCase1 extends DriverClass {
	Logger logger= Logger.getLogger(TestCase1.class.getName());
	
	@Test
	public void test1() {
		driver.get("https://github.com/");
		logger.info(Locator.getProperty("twitter.login.username.xpath"));
		driver.close();
	}

}
