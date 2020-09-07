package ResercheriOSTestCases;


	import java.nio.file.Paths;
	import java.util.ArrayList;

	import org.testng.annotations.Test;

	import Data.DataRepository;
	import Data.ResearcherData;
	import Helpers.Pages;
	import Helpers.TestBaseClass;

	public class Registration extends Pages {
		private ResearcherData researcherDataTemplates;
		private DataRepository<ResearcherData> researcherDataRepository;
		private static ArrayList<ResearcherData> researcherDataList;
		private static String TestCase;
		private static ResearcherData dataSet = null;
		private static ResearcherData researcherData = null;
		private static String testCase = null;

		
		public static void RegistrationReport() throws Exception {
			Registration reg = new Registration();
			reg.testRegistration();
			driver.closeApp();
		}
		@Test
		public void testRegistration() throws Exception {
			TestBaseClass.appLaunch();
			researcherDataTemplates = new ResearcherData();
			researcherDataRepository = new DataRepository<ResearcherData>(researcherDataTemplates);
			String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
			System.out.println("currentDirectory:" + Paths.get(currentDirectory, "/src/TestData").toString());
			researcherDataList = researcherDataRepository.GetData(Paths.get(currentDirectory, "/src/TestData").toString());
			TestCase = TestBaseClass.getTestCaseName();
			check_Registration();
		}

		public static void check_Registration() throws Exception {
			for (int i = 1; i < researcherDataList.size(); i++) {
				researcherData = researcherDataList.get(i);
				testCase = researcherData.getTestCases();
				if (testCase.equals(TestCase)) {
					dataSet = researcherData;
				}
			}
			switch (dataSet.getTestCases()) {
			case "Registration":
				registrationReport();
				break;
			}
		}

		public static void registrationReport() throws Exception {
			OnbordingPage().clickOnAllow();
			OnbordingPage().LoginByEmail();
			/*OnbordingPage().clickOnContinueEmail();*/
			OnbordingPage().clickOnClickhere();
			RegistrationPage().enterFullName(dataSet.getfname());
			RegistrationPage().enterEmail(dataSet.getemail());
			RegistrationPage().enterPassword(dataSet.getPassword());
			RegistrationPage().hideKeyBord2();
			RegistrationPage().clickOnDone();
			RegistrationPage().clickOnContactPermission();
			RegistrationPage().clickOnTermsAndConditions();
			RegistrationPage().clickOnOk();
			RegistrationPage().clickOnNext();
		}
	}

	

