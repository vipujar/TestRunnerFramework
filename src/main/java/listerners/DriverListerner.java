package listerners;

import org.openqa.selenium.support.events.*;
import java.util.logging.Logger;
import java.lang.reflect.Method;
import org.openqa.selenium.*;
public class DriverListerner implements WebDriverListener  {
	Logger logger
    = Logger.getLogger(DriverListerner.class.getName());
	
public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
	// TODO Auto-generated method stub
	String arguments="";
	if(!(args==null)) {
		for(int i=0;i<args.length;i++) {
			arguments+=args[i];
		}
	}
	else {
		arguments="No Args Passed";
	}
	logger.info(method.getName() + " method called with arguments "+ arguments );
	
}


	   public void beforeGet(WebDriver driver, String url) {
	       logger.info("About to open a page " + url);
	     }




}
