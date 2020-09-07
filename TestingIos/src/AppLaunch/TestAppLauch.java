package AppLaunch;

import java.io.FileReader;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAppLauch {
	@Test
	public static void main(String args[])throws Exception {
		IOSDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Code to launch the app
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 11");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ios");
	
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.6");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		

		cap.setCapability("app","/Users/harshada/Desktop/Researcher.app");

				driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		Thread.sleep(5000);
		System.out.println("App open");
		// checkFuncationlty(driver);
		MobileElement elementAllow = (MobileElement) driver
				.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]"));
		elementAllow.click();
		Thread.sleep(2000);
		System.out.println("ALLOW");
		loginByEmail(driver);
	}

	public static void loginByEmail(IOSDriver driver) throws Exception {
		String continueByEmailIsClickable = "";
		String csvFile = "//Users//praful//Desktop//TestContinueByEmail.csv";
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		String[] cell = reader.readNext();
		while ((cell = reader.readNext()) != null) {
			try {
				MobileElement elementContniue = (MobileElement) driver
						.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue with Email\"]"));
				elementContniue.click();
				/* LOGIN SCREEN IS DISPLAY */
				try {
					MobileElement elementLoginScreen = (MobileElement) driver
							.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"LOG IN\"])[1]"));
					if (elementLoginScreen.isDisplayed()) {
						continueByEmailIsClickable = "Pass";
					} else {
						continueByEmailIsClickable = "Fail";
					}
				} catch (Exception e) {
					continueByEmailIsClickable = "NA";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("CONDITION 1: ");
			System.out.println("======================");
			System.out.println("Continue By Email Is Clickable :" + continueByEmailIsClickable);

			String keyword_username = cell[0];
			String keyword_password = cell[1];
			MobileElement enterUserName = (MobileElement) driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField"));
			//enterUserName.click();
			Thread.sleep(2000);
			enterUserName.sendKeys(keyword_username);
			Thread.sleep(2000);
			MobileElement enterPassword = (MobileElement) driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField"));
			enterPassword.sendKeys(keyword_password);
			Thread.sleep(2000);
			/* Hide KeyBord */
			MobileElement elementLoginScreen = (MobileElement) driver
					.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"LOG IN\"])[1]"));
			elementLoginScreen.click();
			Thread.sleep(2000);
			/* DONE */
			MobileElement elementLogin = (MobileElement) driver
					.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"LOG IN\"])[2]"));
			elementLogin.click();
			Thread.sleep(18000);

		}
	}

}
