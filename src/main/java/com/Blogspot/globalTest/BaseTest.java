package com.Blogspot.globalTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Blogspot.Utilities.Log;
import com.Blogspot.Utilities.propertyutil;


public class BaseTest {
	
	private WebDriver driver;
	
	@BeforeSuite
	public void intilize() throws IOException {
		propertyutil.intilizeproperty();
		DOMConfigurator.configure("log4j.xml");
	}
	
@BeforeMethod
	public void launchbrowser() {
		String browserName=propertyutil.readproperty("browsername");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",propertyutil.readproperty("chromedriverpath"));
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",propertyutil.readproperty("firefoxdriverpath"));
			driver=new FirefoxDriver();
		}else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",propertyutil.readproperty("iedriverpath"));
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("Look like you passed Invalied browser");
			Log.error("Look like you passed invalied Browser");
		}
		Log.info("Successfully Lanch the Browser");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
			
	}
	@BeforeMethod
	public void openApplication() {
		String URL=propertyutil.readproperty("url");
		driver.get(URL);
		Log.info("Successfully Open the Application");
	}
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		Log.info("Successfully Close the Browser");
	}
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
	
}
