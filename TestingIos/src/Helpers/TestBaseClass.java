package Helpers;

import java.net.URL;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseClass {
	public static IOSDriver driver;

	public static void appLaunch() throws Exception {
		String deviceName = null;
		String platFormName = null;
		String platFormVersion = null;
		String automationName = null;
		String applicationPath = null;
		ConfigFileReader fileReader = new ConfigFileReader();
		deviceName = fileReader.getDeviceName();
		platFormName = fileReader.getPlatFormName();
		platFormVersion = fileReader.getPlatFormVersion();
		automationName = fileReader.getAutomationName();
		applicationPath = fileReader.getApplicationPath();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platFormName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platFormVersion);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		cap.setCapability("app", applicationPath);
		cap.setCapability("newCommandTimeout", "55000");
		driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		Thread.sleep(5000);

	}

	public static String getTestCaseName() throws Exception {
		String testCase = null;
		ConfigFileReader fileReader = new ConfigFileReader();
		String TestCase = fileReader.getTestCaseName();
		switch (TestCase) {
		case "LoginByEmail":
			TestCase = "LoginByEmail";
			break;
		case "LoginByGoogle":
			TestCase = "LoginByGoogle";
			break;
		case "LoginByFaceBook":
			TestCase = "LoginByFaceBook";
			break;
		case "Registration":
			TestCase = "Registration";
			break;
		case "LoginByAppleId":
			TestCase = "LoginByAppleId";
			break;
		//case "BookmarkIcon":
			//TestCase = "BookmarkIcon";
			// System.out.println("4." + TestCase);
		default:
			break;
		}
		return TestCase;
	}
}
