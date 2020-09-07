package Helpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.appium.java_client.ios.IOSDriver;

public class DriverInstance {
	private static IOSDriver driver = null;
	private static ConfigFileReader fileReader = null;

	public static IOSDriver InitialiseDriver() throws Exception {
		if (driver != null)
			return driver;
		if (fileReader == null)
			fileReader = new ConfigFileReader();
		String driverName = fileReader.getDriver();
		return GetIOSDriver(driverName);
	}

	private static IOSDriver GetIOSDriver(String mobileDriver) {
		switch (mobileDriver) {
		case "iOSDriver":
			copyDriver(mobileDriver);
			break;
		}
		return driver;
	}

	private static void copyDriver(String mobileDriver) {
		String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
		Path targetPath = Paths.get(currentDirectory, mobileDriver);
	}
}
