package com.testautomation.Listeners;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.print.attribute.standard.Destination;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.stepautomation.StepDef.Hook;
import com.stepautomation.StepDef.StepDefinition;
import com.testautomation.TestRunner.TestRunner;
import com.testautomation.Utility.Baseproperty;
import cucumber.api.CucumberOptions;
import gherkin.ast.Scenario;



public class ITestListenerImpl extends Baseproperty implements ITestListener
{
	ExtentTest test;
	ExtentReportNG extentreportNG = new ExtentReportNG();
	ExtentReports extent = ExtentReportNG.getReportObject();
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Itest Scenario pass:"+Hook.scenarioname);
		test = extent.createTest(Hook.scenarioname);
		test.log(Status.PASS,"PASS");
	}
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Itest Scenario fail:"+Hook.scenarioname);
		test = extent.createTest(Hook.scenarioname);
		test.log(Status.FAIL,"FAIL");
		
		 try {
			test.addScreenCaptureFromPath(Screenshots());
		} catch (IOException e) {
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(Hook.scenarioname);
		test.log(Status.SKIP,"Skip");
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		driver.close();
		driver.quit();
		
	}
	

}
