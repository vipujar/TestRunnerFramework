package module2;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import common.DriverClass;
import core.InitBrowser;
import listerners.DriverListerner;

public class TestCase1 extends DriverClass{
	Logger logger
    = Logger.getLogger(TestCase1.class.getName());
	@Test
	public void test1() {
		driver.get("https://google.com/");
		driver.close();
	}

}
