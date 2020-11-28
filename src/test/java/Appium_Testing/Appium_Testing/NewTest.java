package Appium_Testing.Appium_Testing;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


    

public class NewTest {
	
	
	
	static AppiumDriver<MobileElement> driver;
	
 
  @BeforeMethod
  public void beforeClass() throws Exception {
	 
	  try {
	  
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("deviceName", "OPPO F15");
	  cap.setCapability("udid", "S8ONIRMFTWAIPV5L");
	  cap.setCapability("automationName", "UiAutomator2");
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("platformVersion", "10.0");
	  
      cap.setCapability("ignoreHiddenApiPolicyError", true);
      cap.setCapability("autoGrantPermissions", "true");
      cap.setCapability("autoAcceptAlerts", "true");
      
	  
	 /* cap.setCapability("appPackage","com.vl.spicejet" );
	  cap.setCapability("appActivity", "com.vl.spicejet.MainActivity");*/
      
       cap.setCapability("appPackage","io.appium.android.apis" );
	  cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	  
	  
	  
	 URL url = new URL("http://127.0.0.1:4723/wd/hub");
	 
	 
	  
	  driver = new AppiumDriver<MobileElement>(url,cap);
	  Thread.sleep(1000);
	  
	  
	  /*allowAppPermission();*/
	  }catch(Exception exp) {
		  System.out.println(exp.getCause());
		  System.out.println(exp.getMessage());
		  exp.printStackTrace();
		  
		  
		  
	  }
	  
  }
  
  @Test
  public void Preference() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
	  driver.findElement(By.id("android:id/checkbox")).click();
	  driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	  driver.findElement(By.className("android.widget.EditText")).sendKeys("Subash");
	  driver.findElement(By.id("android:id/button1")).click();
	  
	  
	  
	 /* Thread.sleep(10000);*/
	  
	  /*
	 driver.findElement(MobileBy.xpath("//*[@class='android.view.ViewGroup'][2]")).click();*/
	 
	  System.out.println("App start");
  }
  
  
  @Test
  public void view() {
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  TouchAction touch = new TouchAction(driver);
	  WebElement tapelement = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"));
	  touch.tap(tapOptions().withElement(element(tapelement))).perform();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
	  WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	  touch.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release().perform();
	  
	  
	 
	  
	  
	  
  }
  
  @Test
  
  public void swipeclock() {
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2. Inline\"]")).click();
	  driver.findElement(By.xpath("//*[@content-desc='6']")).click();
  }

  @AfterMethod
  public void Closing() {
	  driver.quit();
	  
  }
 /* public void allowAppPermission(){
	  while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0) 

	  {  driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
	  }*/
	 }


