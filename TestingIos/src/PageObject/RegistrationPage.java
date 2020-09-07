
package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Reporter;

import Helpers.TestBaseClass;
import io.appium.java_client.MobileElement;

public class RegistrationPage extends TestBaseClass {
	public RegistrationPage() {
		this.driver = driver;
	}

	private MobileElement enter_full_name;
	private MobileElement enter_email;
	private MobileElement enter_password;
	private MobileElement click_on_done;
	private MobileElement click_on_contact_permission;
	private MobileElement click_on_terms_conditions;
	private MobileElement click_on_ok;
	private MobileElement hide_keybord;
	private List<MobileElement> click_on_Next;

	public void enterFullName(String fName) {
		String enterFullNameIsDisplay = "";
		try {
			enter_full_name = (MobileElement) driver.findElement(By.name("Full name"));
					//(By.xpath("//XCUIElementTypeApplication[@name=\\\"Researcher\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]"));
			if (enter_full_name.isDisplayed()) {
				enterFullNameIsDisplay = "PASS";
				enter_full_name.sendKeys(fName);
			} else {
				enterFullNameIsDisplay = "FAIL";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Reporter.log("Enter Full Name : " + enterFullNameIsDisplay);
		Reporter.log(
				"==================================================================================================");
	}

	public void enterEmail(String email) {
		String enterEmailIsDisplay = "";
		try {
			enter_email = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]"));
			if (enter_email.isDisplayed()) {
				enterEmailIsDisplay = "PASS";
				enter_email.sendKeys(email);
			} else {
				enterEmailIsDisplay = "FAIL";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Reporter.log("Enter Email : " + enterEmailIsDisplay);
		Reporter.log(
				"==================================================================================================");
	}

	public void enterPassword(String password) {
		String enterPasswordIsDisplay = "";
		try {
			enter_password = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField"));
			if (enter_password.isDisplayed()) {
				enterPasswordIsDisplay = "PASS";
				enter_password.sendKeys(password);
			} else {
				enterPasswordIsDisplay = "FAIL";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Reporter.log("Enter Password : " + enterPasswordIsDisplay);
		Reporter.log(
				"==================================================================================================");
	}
	
	
	
	// HIDE KEYBORD
		public void hideKeyBord2() {
			try {
				hide_keybord = (MobileElement) driver
						.findElement(By.name("DONE"));
				hide_keybord.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	

	public void clickOnDone() {
		String doneIsClicked = "";
		try {
			click_on_done = (MobileElement) driver.findElement(By.name("DONE"));
			click_on_done.click();
			Thread.sleep(5000);
			try {
				MobileElement contactPermission = (MobileElement) driver
						.findElement(By.xpath("//XCUIElementTypeButton[@name=\"DONE\"]"));
				if (contactPermission.isDisplayed()) {
					doneIsClicked = "PASS";
				} else {
					doneIsClicked = "FAIL";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Reporter.log("Done is Clicked : " + doneIsClicked);
			Reporter.log(
					"==================================================================================================");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// CONTACT PERMISSION
	public void clickOnContactPermission() throws Exception {
		String contactPermissionIsClicked = "";
		try {
			click_on_contact_permission = (MobileElement) driver
					.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"checkbox\"])[1]"));
			click_on_contact_permission.click();
			Thread.sleep(2000);
			contactPermissionIsClicked = "PASS";
		} catch (Exception e) {
			// TODO: handle exception
			contactPermissionIsClicked = "FAIL";
		}
		Reporter.log("Contact And Permission is Clicked : " + contactPermissionIsClicked);
		Reporter.log(
				"==================================================================================================");
	}

	// TERMS CONDITIONS
	public void clickOnTermsAndConditions() throws Exception {
		String termsAndConditionsIsClicked = "";
		try {
			click_on_terms_conditions = (MobileElement) driver
					.findElement(By.xpath("(//XCUIElementTypeImage[@name=\"checkbox\"])[2]"));
			click_on_terms_conditions.click();
			Thread.sleep(3000);
			termsAndConditionsIsClicked = "PASS";
		} catch (Exception e) {
			// TODO: handle exception
			termsAndConditionsIsClicked = "FAIL";
		}
		Reporter.log("Terms And Conditions is Clicked : " + termsAndConditionsIsClicked);
		Reporter.log(
				"==================================================================================================");
	}

	public void clickOnOk() throws Exception {
		click_on_ok = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"));
		click_on_ok.click();
		Thread.sleep(3000);
	}

	// CLICK ON NEXT
	public void clickOnNext() throws Exception {
		click_on_Next = driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\"Next\"]"));
		for (int i = 0; i < click_on_Next.size(); i++) {
			MobileElement e = click_on_Next.get(i);
			System.out.println(e.getText());
		}
		Thread.sleep(3000);
	}
}
