package AppLaunch;

import java.net.URL;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class LoginByGoogle {
public static void testLoginByGoogle(IOSDriver driver) throws Exception{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "IPhone 7 plus");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
	cap.setCapability("app", "/Users/praful/Desktop/Researcher.app");
	driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	Thread.sleep(5000);
	System.out.println("App open");
	// checkFuncationlty(driver);
	MobileElement elementAllow = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]"));
	elementAllow.click();
	Thread.sleep(2000);
	System.out.println("ALLOW");
}
}
