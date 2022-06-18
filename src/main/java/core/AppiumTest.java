//package core;
//import java.net.MalformedURLException;
//import java.io.File;
//import java.net.URL;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeClass;
//
//
//
//import org.testng.annotations.*;
// 
//public class AppiumTest {
// 
// WebDriver driver;
// 
// @BeforeClass
// public void setUp() throws Exception {
// 
////location of the app
// File app = new File("C:\\Users\\vbp20\\Downloads", "apkinfo.apk");
//  
// //To create an object of Desired Capabilities
// DesiredCapabilities capability = new DesiredCapabilities();
////OS Name
// 
// capability.setCapability(CapabilityType.BROWSER_NAME, "");
////Mobile OS version. In My case its running on Android 4.2
// capability.setCapability("platformVersion", "7.1.1");
// capability.setCapability("app", app.getAbsolutePath());
////To Setup the device name
// capability.setCapability("deviceName","ZH33L2P2KP"); 
// capability.setCapability("platformName","Android");
////set the package name of the app
// capability.setCapability("appPackage", "de.migali.soft.apkinfo");
// //set the Launcher activity name of the app
// capability.setCapability("appActivity", "Start");
// capability.setCapability("automationName", "UiAutomator1");
////driver object with new Url and Capabilities
// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
// }
// 
// @Test
//public void testApp() throws MalformedURLException, InterruptedException{
//
//System.out.println("App launched");
//Thread.sleep(10000);
// // locate Add Contact button and click it
// //locate input fields and type name and email for a new contact and save it
// List<WebElement> textFields = driver.findElements(By.className("android.widget.Button"));
//textFields.get(0).click();
//System.out.println(textFields.get(0).getText());
//
// //insert assertions here
// }
// }