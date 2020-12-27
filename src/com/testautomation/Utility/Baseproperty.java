package com.testautomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.stepautomation.StepDef.Hook;

public class Baseproperty {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static ExtentReports extent;
	public static ExtentTest scenariodef;
	public static ExtentTest features;
	
	static String sysprojectpath = System.getProperty("user.dir");
		
	public WebDriver initializedriver() throws IOException {
		
		System.setProperty("webdriver.chrome.driver",""+System.getProperty("user.dir")+"\\resources\\chromedriver.exe"); 
		driver = new ChromeDriver(); driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; 
	}
	
	public static String Screenshots() throws IOException {
		
		String directory = System.getProperty("user.dir")+"\\Screenshots\\"+Hook.scenarioname+".png";
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File(directory));
		String destination=directory;
		return destination;
	}
	
	public void waitForPageLoad(){
		
		wait = new WebDriverWait(driver, 350);
		ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>()
		{
		public Boolean apply(WebDriver driverFB)
		{
		 // System.out.println("Page is loading...");
		if(isAlertPresent())
		{
		Alert alert = driverFB.switchTo().alert();
		alert.accept();
		}
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
		};
		wait.until(pageLoaded);
	}

	@SuppressWarnings("unused")
	public boolean assertTrue(boolean matches)
	{
		return false;
	}

	@SuppressWarnings("unused")
	public String closeAlertAndGetItsText()
	{
		return null;
	}

	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException ex)
		{
			return false;
		}
	}
	

}
