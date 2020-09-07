package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	private static Properties properties;
	private final String propertyFilePath = "configs//ConfigurationProperties";

	public ConfigFileReader() throws Exception {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String getPlaceOrderDataFileName(String key) {
		String placeOrderFileName = properties.getProperty(key);
		if (placeOrderFileName != null)
			return placeOrderFileName;
		else
			throw new RuntimeException(String.format("%s not specified in the ConfigurationProperties file.", key));
	}

	public String getTestCaseName() {
		String testname = properties.getProperty("TestCase");
		if (testname != null)
			return testname;
		else
			throw new RuntimeException();
	}

	public String getDriver() {
		String driver = properties.getProperty("Driver");
		if (driver != null)
			return driver;
		else
			throw new RuntimeException();
	}

	public String getDeviceName() {
		String deviceName = properties.getProperty("DeviceName");
		if (deviceName != null)
			return deviceName;
		else
			throw new RuntimeException();
	}

	public String getPlatFormName() {
		String platFormName = properties.getProperty("PlatFormName");
		if (platFormName != null)
			return platFormName;
		else
			throw new RuntimeException();
	}

	public String getPlatFormVersion() {
		String platFormVersion = properties.getProperty("PlatFormVersion");
		if (platFormVersion != null)
			return platFormVersion;
		else
			throw new RuntimeException();
	}

	public String getAutomationName() {
		String automationName = properties.getProperty("AutomationName");
		if (automationName != null)
			return automationName;
		else
			throw new RuntimeException();
	}

	public String getApplicationPath() {
		String applicationPath = properties.getProperty("AppLocation");
		if (applicationPath != null)
			return applicationPath;
		else
			throw new RuntimeException();
	}
}
