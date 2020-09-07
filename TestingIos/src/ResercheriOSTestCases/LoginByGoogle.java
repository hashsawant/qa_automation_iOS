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


public class LoginByGoogle extends Pages {
	private ResearcherData researcherDataTemplates;
	private DataRepository<ResearcherData> researcherDataRepository;
	private static ArrayList<ResearcherData> researcherDataList;
	private static String TestCase;
	private static ResearcherData dataSet = null;
	private static ResearcherData researcherData = null;
	private static String testCase = null;

	public static void testReportLoginByGoogle() throws Exception {
		LoginByGoogle loginByGoogle = new LoginByGoogle();
		loginByGoogle.testLoginByGoogle();
		driver.closeApp();
	}
	@Test
	public void testLoginByGoogle() throws Exception {
		TestBaseClass.appLaunch();
		researcherDataTemplates = new ResearcherData();
		researcherDataRepository = new DataRepository<ResearcherData>(researcherDataTemplates);
		String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("currentDirectory:" + Paths.get(currentDirectory, "/src/TestData").toString());
		researcherDataList = researcherDataRepository.GetData(Paths.get(currentDirectory, "/src/TestData").toString());
		TestCase = TestBaseClass.getTestCaseName();
		System.out.println("Test Case Is:" + TestCase);
		check_flow_login_with_google();
	}

	public static void check_flow_login_with_google() throws Exception {
//		for (ResearcherData data : researcherDataList) {
//			String testCase = data.getTestCases();
//			
//			if (data.getTestCases().equals(TestCase)) {
//				dataSet = data;
//			}
//			switch (dataSet.getTestCases()) {
//			case "BookmarkIcon":
//				bookMarkIconTestCase();
//			}
//		}
		for (int i = 1; i < researcherDataList.size(); i++) {
			researcherData = researcherDataList.get(i);
			testCase = researcherData.getTestCases();
			if (testCase.equals(TestCase)) {
				dataSet = researcherData;
			}
		}
		switch (dataSet.getTestCases()) {
		case "LoginByGoogle":
			onbordingLoginGoogle();
			break;
		}
	}


	private static void onbordingLoginGoogle() throws Exception {
		OnbordingPage().clickOnAllow();
		OnbordingPage().LoginByGoogle();
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



