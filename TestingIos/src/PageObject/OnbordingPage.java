package PageObject;

import java.util.List;

import org.openqa.selenium.By;

import Helpers.TestBaseClass;
import io.appium.java_client.MobileElement;

public class OnbordingPage extends TestBaseClass {
	public OnbordingPage() {
		this.driver = driver;
	}

	private MobileElement click_allow;
	private MobileElement login_by_email;
	private MobileElement select_click_here;
	private MobileElement enter_email_id;
	private MobileElement enter_password;
	private MobileElement hide_keybord;
	private MobileElement click_on_login;
	private MobileElement enter_main_feed_page;
	private MobileElement main_feed_page_is_clickable;
	private MobileElement select_next;
	private MobileElement select_journal;
	private MobileElement select_journal_next;
	private MobileElement select_interest;
	private MobileElement select_next_interset;
	private List<MobileElement> select_journals;
	private MobileElement select_follow;
	private MobileElement select_skip;
	private MobileElement login_by_FB;
	private MobileElement login_by_Google;
	private MobileElement login_by_AppleID;

	public void clickOnAllow() {
		try {
			click_allow = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]"));
			click_allow.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void LoginByEmail() throws Exception {
		try {
			/*login_by_email = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue with Email\"]"));
			login_by_email.click();*/
			login_by_email = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeButton[@name=\"logo mail light\"]"));
			login_by_email.click();
			
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	/* CLICK HERE */
	public void clickOnClickhere() {
		try {
			select_click_here = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Click here\"]"));
			select_click_here.click();
			/*if (select_click_here.isDisplayed()) {
				//clickHereIsClicked = "PASS";
				select_click_here.click();
				Thread.sleep(5000);
			} else {
				//clickHereIsClicked = "FAIL";
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public void enterEmailId(String emailId) {
		try {
			enter_email_id = (MobileElement) driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField"));
			enter_email_id.sendKeys(emailId);
			
			//XCUIElementTypeButton[@name="logo mail light"]
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void enterUserPassword(String password) {
		try {
			enter_password = (MobileElement) driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField"));
			enter_password.sendKeys(password);
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// HIDE KEYBORD
	public void hideKeyBord1() {
		try {
			hide_keybord = (MobileElement) driver
					.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"LOG IN\"])[1]"));
			hide_keybord.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// LOGIN
	public void clickOnLogin() {
		String researcherAppLoginSuccessfully = "";
		String mainFeedPageIsDisplay = "";
		try {
			click_on_login = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LOG IN\"]"));
			click_on_login.click();
			if (click_on_login.isDisplayed()) {
				click_on_login.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// NEXT
	public void clickOnNext() {
		try {
			select_next = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Next\"]"));
			select_next.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// SELECT JOURNAL
	public void clickOnJournal() {
		try {
			select_journal = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Medical & Health Sciences\"]"));
			select_journal.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// JOURNAL NEXT

	public void clickOnNextInJournal() {
		try {
			select_journal_next = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next\"]"));
			select_journal_next.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// SELECT SUBJECT AREA OF INTERSET
	public void clickOnAreaOfIntereset() {
		try {
			select_interest = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Advanced & Specialised Nursing\"]"));
			select_interest.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void clickOnNextInterset() {
		try {
			select_next_interset = (MobileElement) driver
					.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next\"]"));
			select_next_interset.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* SELECT JOURNALS */
	public void clickOnJournals() {
		select_journals = driver.findElements(By.xpath(
				"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
		for (int i = 0; i < select_journals.size(); i++) {
			MobileElement eJournals = select_journals.get(i);
			eJournals.click();
			if (i == 0) {
				break;
			}
		}
	}

	// CLICK ON FOLLOW
	// //XCUIElementTypeApplication[@name="Researcher"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]
	public void clickOnFollow() {
		try {
			select_follow = (MobileElement) driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Researcher\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]"));
			select_follow.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// CLICK ON SKIP
	public void clickOnSkip() {
		try {
			select_skip = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Skip\"]"));
			select_skip.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// LOGIN BY GOOGLE
		public void LoginByGoogle() {
			try {
				select_skip = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"logo google light\"]"));
				select_skip.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	// LOGIN BY FB
				public void LoginByFb() {
					try {
						select_skip = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"logo facebook\"]"));
						select_skip.click();
						Thread.sleep(5000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
	// LOGIN BY AppleID
				public void LoginByAppleId() {
					try {
						select_skip = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"logo apple\"]"));
						select_skip.click();
						Thread.sleep(5000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
}
