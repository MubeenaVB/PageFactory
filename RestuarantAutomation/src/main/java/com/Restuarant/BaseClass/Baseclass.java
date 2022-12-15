package com.Restuarant.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

import com.Restaurant.Action.ActionClass;
import com.Restaurant.Utilities.ExcelReadTest;
import com.Restaurant.Utilities.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static Properties prop;
	public static WebDriver driver;
	public static ActionClass action;

	@BeforeSuite
	public void beforeSuite() {
		// used to execute log4j config file(log4j.xml)
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
	}

	// loadConfig method is to load the configuration
	@BeforeTest
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void launchApp() {

		String browserName = prop.getProperty("Broswer");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		action = new ActionClass();
		// Implicit TimeOuts
		action.implicitWait(driver, 10);
		// PageLoad TimeOuts
		action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void AfterMethod()
	{
		driver.close();
	}
	@AfterSuite
	public void Closing() {
		ExtentReport.endReport();
	//driver.close();
	}

}
