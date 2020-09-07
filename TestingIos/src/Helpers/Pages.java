package Helpers;


import PageObject.MainFeedPage;
import PageObject.OnbordingPage;
import PageObject.RegistrationPage;

public abstract class Pages extends TestBaseClass{
	


	private static MainFeedPage _mainfeedpage;

	public static MainFeedPage MainFeedPage() {
		return (_mainfeedpage == null) ? _mainfeedpage = new MainFeedPage() : _mainfeedpage;
	}

	private static OnbordingPage _onbordingpage;

	public static OnbordingPage OnbordingPage() {
		return (_onbordingpage == null) ? _onbordingpage = new OnbordingPage() : _onbordingpage;
	}
	
	private static RegistrationPage _registrationpage;

	public static RegistrationPage RegistrationPage() {
		return (_registrationpage == null) ? _registrationpage = new RegistrationPage() : _registrationpage;
	}

	
}
