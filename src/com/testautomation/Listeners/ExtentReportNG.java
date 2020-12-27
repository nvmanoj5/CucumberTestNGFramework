package com.testautomation.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testautomation.Utility.Baseproperty;

public class ExtentReportNG extends Baseproperty  {

public static ExtentHtmlReporter report = null;

public static ExtentReports getReportObject(){
	
	String reportLocation = System.getProperty("user.dir")+"\\reports\\index.html";
	report = new ExtentHtmlReporter(reportLocation);		
	report.config().setDocumentTitle("Practice Automation Report");
	report.config().setReportName("Practice Automation Report");
	report.config().setTheme(Theme.DARK);
	System.out.println("Extent Report location initialized . . .");
	report.start();

	extent = new ExtentReports();
	extent.attachReporter(report);		
	extent.setSystemInfo("Tester Name", "Manoj");
	extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	return extent;
}


}
