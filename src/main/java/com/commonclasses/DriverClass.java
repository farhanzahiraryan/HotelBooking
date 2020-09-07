package com.commonclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {

	static WebDriver driver;

	public static WebDriver getDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\faryan\\Desktop\\driver libraries\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\faryan\\Desktop\\driver libraries\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		return driver;

	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}

	}

}
