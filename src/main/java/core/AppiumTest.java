package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AppiumTest {
 
	AndroidDriver driver;
	WebDriver chartdriver;
	 Activity kite ;
	 double Cash;
	 double Capital=100000,pertradecapital=0.2;
	 
 @Test(groups= {"kite"})
 public void asetUp() throws Exception {
 
//location of the app
 File app = new File("C:\\Users\\vbp20\\Downloads", "zerodha.apk");
  
 //To create an object of Desired Capabilities
 DesiredCapabilities capability = new DesiredCapabilities();
//OS Name
 
 capability.setCapability(CapabilityType.BROWSER_NAME, "");
//Mobile OS version. In My case its running on Android 4.2
 capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
 capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//To Setup the device name
 capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
 capability.setCapability(MobileCapabilityType.DEVICE_NAME,"R9ZW106Z15T"); 
 capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//set the package name of the app
// capability.setCapability("appium:appPackage", "com.zerodha.kite3");
// //set the Launcher activity name of the app
// capability.setCapability("appium:appActivity", "com.zerodha.kite3.MainActivity");
 capability.setCapability("appium:unlockType","pin"); 
 capability.setCapability("appium:unlockKey","9738");
 capability.setCapability("appium:noReset", true);
 capability.setCapability("appium:autoLaunch", true);

//driver object with new Url and Capabilities
 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
 }
 
 @Test(groups= {"kite"})
public void btestApp() throws MalformedURLException, InterruptedException,Exception{
	  kite = new Activity("com.zerodha.kite3", "com.zerodha.kite3.MainActivity");
	  driver.startActivity(kite);
	  
System.out.println("App launched");
Thread.sleep(30000);
//driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).click();
Actions action=new Actions(driver);
action.sendKeys("9738").sendKeys(Keys.ENTER).build().perform();

//get cash available
//get holding and positions
Thread.sleep(5000);
getcash();
getholdings();
getpositions();


//Thread.sleep(5000);
//getholdings();
//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Button[2]")).click(); 
// locate Add Contact button and click it
 //locate input fields and type name and email for a new contact and save it
//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Login to Kite\"]")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[2]")).sendKeys("zr9978");;
//Thread.sleep(5000);
//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")).click();
//Thread.sleep(5000);
//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")).sendKeys("new5233160v");;
//Thread.sleep(2000);
//driver.findElement(By.xpath("//android.view.View[@content-desc=\"LOGIN\"]")).click();;
//Thread.sleep(5000);
//System.out.println("EEEE="+getOTP());
//driver.startActivity(kite);

 }
 
 @Test(groups= {"kite"})
 public void cbuylist() {
	 JSONParser parser = new JSONParser();
	  try {
          Object obj = parser.parse(new FileReader("./holdings.json"));
          Object objscan = parser.parse(new FileReader("./scanner.json"));
          // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
     
          // A JSON array. JSONObject supports java.util.List interface.
          JSONArray companyList = (JSONArray) obj;
          JSONArray objscanList = (JSONArray) objscan;
          // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
          // Iterators differ from enumerations in two ways:
          // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
          // 2. Method names have been improved.
          Iterator<JSONObject> iterator = objscanList.iterator();
          while (iterator.hasNext()) {
        	  JSONObject jsonObject = (JSONObject) iterator.next();
       
          
              if(!companyList.contains(jsonObject)) {
            	  addstock(jsonObject.get("name").toString());
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
	
	}
public void getcash() throws InterruptedException {

 driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='account, tab']")).click();
 driver.findElement(By.xpath("//android.widget.Button[@content-desc='Funds']")).click();
 Thread.sleep(5000);
 String cash=driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Available cash')]")).getAttribute("content-desc");
 System.out.println(cash);
 Cash=Double.parseDouble(cash.toString().split("\n")[1].replace(",", ""));

 System.out.println(Cash);
 driver.navigate().back();
}
public void addstock(String stock) throws InterruptedException {

	 driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Watchlist, tab\"]")).click();
	 driver.findElement(By.xpath("//android.view.View[@content-desc=\"Search & add\"]")).click();
	 
	
	 

	Actions action=new Actions(driver);
	action.sendKeys(stock).sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'"+stock+"')]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"BUY\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"limit\"]")).click();
	Thread.sleep(2000);
	double price=Double.parseDouble(driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")).getAttribute("text"));
	System.out.println(price);
	Thread.sleep(2000);
	int quantity = 0;
	if(Cash>(Capital*pertradecapital)*0.75) {
	quantity=(int) ((Capital*pertradecapital)/price);
	
	System.out.println("quantity="+quantity);
	driver.findElement(By.xpath("//android.widget.EditText[1]")).click();
	Thread.sleep(3000);
	Actions action1=new Actions(driver);
	action1.sendKeys(Keys.BACK_SPACE).build().perform();
	action1.sendKeys(Integer.toString(quantity)).sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(3000);
//	Actions action1=new Actions(driver);
//	action1.clea("12").sendKeys(Keys.ENTER).build().perform();
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"market\"]")).click();
	driver.findElement(By.xpath("//android.widget.Switch")).click();
	Thread.sleep(2000);
	TouchAction touchAction=new TouchAction<>(driver).press(PointOption.point(250, 735)).waitAction().moveTo(PointOption.point(250, -460)).release().perform();
	driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).click();
	Actions action2=new Actions(driver);
	action2.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
	action2.sendKeys("4").sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.Switch[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")).click();
	Actions action3=new Actions(driver);
	action3.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
	action3.sendKeys("12").sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(2000);
	
	
	Thread.sleep(4000);
	WebElement elementX= driver.findElement(By.xpath("//android.view.View[@content-desc=\"slide to place order\"]/android.widget.ImageView"));
//	int elementY= driver.findElement(By.xpath("//android.view.View[@content-desc=\"slide to place order\"]/android.widget.ImageView")).getLocation().getY();
	Thread.sleep(4000);
	swipeByElements(elementX);
	if(driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Markets are closed')]")).isDisplayed()) {
		 System.out.println("Markets are closed");
		 driver.quit();
	}
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"Close\"]")).click();
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"Clear\"]")).click();
	}
	else {
    System.out.println(Cash +" is not enough for taking position");
	 driver.quit();
	}
	
}
public void swipeByElements (WebElement startElement) {
    int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
    int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
 
    new TouchAction(driver)
        .press(PointOption.point(startX, startY))
        .waitAction()
        .moveTo(PointOption.point(500, 1300))
        .release().perform();
}

@SuppressWarnings("deprecation")
public void getholdings() throws InterruptedException {

	 driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Portfolio, tab\"]")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Tab 1 of 2')]")).click();
	 Thread.sleep(5000);
	TouchAction touchAction=new TouchAction<>(driver).press(PointOption.point(250, 735)).waitAction().moveTo(PointOption.point(250, -460)).release().perform();
	 Thread.sleep(10000);
	 JSONArray employeeList = new JSONArray();
	
	List<WebElement> holdings=driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'quantity')]"));
	 System.out.println("holdings:"+holdings.size()); 
	 for(WebElement ele:holdings) {
		 System.out.println(ele.getAttribute("content-desc"));
		 JSONObject employeeDetails2 = new JSONObject();
		 String con[]=ele.getAttribute("content-desc").split(" ");
		 Pattern p = Pattern.compile("price\\n\\d+[.]*\\d+\\n[A-Z0-9-]+");
		 String substr="";
		for(int i=0;i<con.length;i++) {
		 Matcher m = p.matcher(con[i]);
		 if (m.find()) {
			 substr=m.group();
			 System.out.println("Substr:"+substr);
		 }
		}
	     employeeDetails2.put("name", substr.split("\n")[2]);//.split(" ")[1].split("\n")[2]
	     employeeList.add(employeeDetails2);	
	 }
	 
	 
	 try (FileWriter file = new FileWriter("./holdings.json")) {
	     //We can write any JSONArray or JSONObject instance to the file
	     file.write(employeeList.toJSONString()); 
	     file.flush();

	 } catch (IOException e) {
	     e.printStackTrace();
	 }
//	 WebElement element=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Positions Tab 2 of 2\"]"));//.click();
//	 HashMap<String, Object> scrollObject = new HashMap();
//	 scrollObject.put("direction", "down");
//	 driver.executeScript("mobile: scroll", scrollObject);
//	 driver.executeScript("mobile: scroll", scrollObject);
//	 driver.executeScript("mobile: scroll", scrollObject);


    
	}

public void getpositions() throws InterruptedException, Exception {
	 driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Portfolio, tab\"]")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Tab 2 of 2')]")).click();
	 Thread.sleep(5000);
	
	 JSONParser parser = new JSONParser();
	 Object obj = parser.parse(new FileReader("./holdings.json"));
	 JSONArray positions = (JSONArray) obj;
	List<WebElement> allpositions=driver.findElements(By.xpath("//android.view.View[contains(@content-desc,'quantity')]"));
	 System.out.println("holdings:"+allpositions.size()); 
	 for(WebElement ele:allpositions) {
		 System.out.println(ele.getAttribute("content-desc"));
		 JSONObject employeeDetails2 = new JSONObject();
		 String str=ele.getAttribute("content-desc");
		 System.out.println("qty:"+Integer.parseInt(str.split(" ")[0].split("\n")[1]));
		 if(!str.contains("SOLD HOLDING"));
	     {employeeDetails2.put("name", str.split(" ")[2].split("\n")[1]);
	     positions.add(employeeDetails2);}	
	 }

	

	 try (FileWriter file = new FileWriter("./holdings.json")) {
	     //We can write any JSONArray or JSONObject instance to the file
	     file.write(positions.toJSONString()); 
	     file.flush();

	 } catch (IOException e) {
	     e.printStackTrace();
	 }
	 
	
}

// public String getOTP() {
//	 Activity message = new Activity("com.google.android.apps.messaging","com.google.android.apps.messaging.main.MainActivity");
//	driver.startActivity(message);
//	
//	return driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.TextView[2]")).getAttribute("text");
//
// }
 
 @Test(groups= {"chartink"})
 public void chartinksetUp() throws Exception {
 

	 DesiredCapabilities capability = new DesiredCapabilities();
		
		// 2 Setup a device name. This capability is currently ignored, but remains required on Android.		
	 capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		
		// 3 Setup a name of Android web browser to automate.
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capability.setCapability("chromedriverExecutable","C:\\Users\\vbp20\\Downloads\\chromedriver_win112\\chromedriver.exe");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		 capability.setCapability("appium:unlockType","pin"); 
		 capability.setCapability("appium:unlockKey","9738");
		 capability.setCapability("appium:noReset", false);
		 capability.setCapability("appium:autoLaunch", true);
		// 4 Create an Android driver to initiate the session to Appium server. 
		URL url = new URL("http://127.0.0.1:4723/wd/hub");					
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		
		
		 Thread.sleep(15000);

//set the package name of the app
// capability.setCapability("appium:appPackage", "com.zerodha.kite3");
// //set the Launcher activity name of the app
// capability.setCapability("appium:appActivity", "com.zerodha.kite3.MainActivity");


//driver object with new Url and Capabilities
		 driver.get("https://chartink.com/screener/short-2023-01-07-1");
		 List<WebElement> indexes= driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr//td[3]"));
		 boolean niftystrength=false;
		 if(indexes.size()>=1) {
			 for(WebElement index :indexes) {
				 System.out.println("index:"+index.getText());
				 if(index.getText().equalsIgnoreCase("NIFTY")) {
					 niftystrength=true;
				 }
			 }
		 }
		 JSONArray newlist = new JSONArray();
if(niftystrength) {
 driver.get("https://chartink.com/screener/quant-t1");
 List<WebElement> names= driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr//td[3]"));
List<String> stocks;


//JSONParser parser = new JSONParser();
//Object obj = parser.parse(new FileReader("./scanner.json"));
//JSONArray employeeList = (JSONArray) obj;
////employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

//     const config :string[]= JSON.parse(loadedConfig);
System.out.println(names.size() +"======");
 for(int i=0;i<names.size();i++){  
	 JSONObject employeeDetails2 = new JSONObject();
     employeeDetails2.put("name", names.get(i).getText());
	 newlist.add(employeeDetails2);
 }

}
else {
	System.out.println("NIfty is weak no scanning");
}

try (FileWriter file = new FileWriter("./scanner.json")) {
    //We can write any JSONArray or JSONObject instance to the file
    file.write(newlist.toJSONString()); 
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}

driver.quit();
 
 }
 private static void parseEmployeeObject(JSONObject employee) 
 {
     //Get employee object within list
	 String firstName=(String) employee.get("name");
      
  
     System.out.println(firstName);
      
     
 }
 
 }