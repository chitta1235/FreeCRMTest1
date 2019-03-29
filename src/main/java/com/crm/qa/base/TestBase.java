package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){ //create constructor
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("C:/Users/chittaranjan/workspace/FreeCRMTest1/src/main/java/com/crm/qa/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void intialization(){ // create intialization method
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/SOFTWARE/chromedriver/chromedriver_win32/"
					+ "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
