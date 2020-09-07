package ResercheriOSTestCases;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

import Data.DataRepository;
import Data.ResearcherData;
import Helpers.Pages;
import Helpers.TestBaseClass;

public class LoginByAppleId extends Pages{
	private ResearcherData researcherDataTemplates;
	private DataRepository<ResearcherData> researcherDataRepository;
	private static ArrayList<ResearcherData> researcherDataList;
	private static String TestCase;
	private static ResearcherData dataSet = null;
	private static ResearcherData researcherData = null;
	private static String testCase = null;

	public static void testReportLoginByAppleId() throws Exception {
		LoginByAppleId loginByAppleId = new LoginByAppleId();
		loginByAppleId.testLoginByAppleId();
		driver.closeApp();
	}
		@Test
		public void testLoginByAppleId() throws Exception {
			TestBaseClass.appLaunch();
			researcherDataTemplates = new ResearcherData();
			researcherDataRepository = new DataRepository<ResearcherData>(researcherDataTemplates);
			String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
			System.out.println("currentDirectory:" + Paths.get(currentDirectory, "/src/TestData").toString());
			researcherDataList = researcherDataRepository.GetData(Paths.get(currentDirectory, "/src/TestData").toString());
			TestCase = TestBaseClass.getTestCaseName();
			System.out.println("Test Case Is:" + TestCase);
			check_flow_login_with_AppleId();
		}

		public static void check_flow_login_with_AppleId() throws Exception {
//			for (ResearcherData data : researcherDataList) {
//				String testCase = data.getTestCases();
//				
//				if (data.getTestCases().equals(TestCase)) {
//					dataSet = data;
//				}
//				switch (dataSet.getTestCases()) {
//				case "BookmarkIcon":
//					bookMarkIconTestCase();
//				}
//			}
			for (int i = 1; i < researcherDataList.size(); i++) {
				researcherData = researcherDataList.get(i);
				testCase = researcherData.getTestCases();
				System.out.println("test case value"+ testCase);
				if (testCase.equals(TestCase)) {
					dataSet = researcherData;
				}
			}
			switch (dataSet.getTestCases()) {
			case "LoginByAppleId":
				onbordingLoginAppleId();
				break;
			}
		}


		private static void onbordingLoginAppleId() throws Exception {
			OnbordingPage().clickOnAllow();
			OnbordingPage().LoginByAppleId();;
			/*OnbordingPage().enterEmailId(dataSet.getemail());
			OnbordingPage().enterUserPassword(dataSet.getPassword());
			OnbordingPage().hideKeyBord1();
			OnbordingPage().clickOnLogin();
			/*OnbordingPage().clickOnNext();
			OnbordingPage().clickOnJournal();
			OnbordingPage().clickOnNextInJournal();
			OnbordingPage().clickOnAreaOfIntereset();
			OnbordingPage().clickOnNextInterset();
			OnbordingPage().clickOnJournals();
			OnbordingPage().clickOnFollow();
			OnbordingPage().clickOnSkip();
			SessionId getSeesionId = driver.getSessionId();
			System.out.println("Session id1:" + getSeesionId);
			Thread.sleep(5000);
			System.out.println("Session id1:" + getSeesionId);*/
		}


	}



