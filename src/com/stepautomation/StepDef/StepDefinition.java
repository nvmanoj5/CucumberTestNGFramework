package com.stepautomation.StepDef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testautomation.PageObjects.AngularpracticePage;
import com.testautomation.PageObjects.AutomationPracticePage;
import com.testautomation.Utility.Baseproperty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition extends Baseproperty{
	
	AngularpracticePage angularpage;
	AutomationPracticePage automationpage;
	
	@Given("open the angular practice page {string}")
	public void open_the_angular_practice_page(String url) throws IOException {
	    
		System.out.println("--- Angular Practice Page Automation Started ---");
		driver = initializedriver();
		driver.get(url);
		waitForPageLoad();
	}

	@When("Enter the vaild name {string} and email id {string} and password {string}")
	public void enter_the_vaild_name_and_email_id_and_password(String name, String email, String password) {
	    
		angularpage = new AngularpracticePage(driver);
		angularpage.Name().sendKeys(name);
		angularpage.Email().sendKeys(email);
		angularpage.Password().sendKeys(password);
	}

	@When("check the Check me out if you Love IceCreams checkbox")
	public void check_the_Check_me_out_if_you_Love_IceCreams_checkbox() {
	    
		if(angularpage.Checkbox().isSelected()) {
			System.out.println("Check me out if you Love IceCreams checkbox already selected");
		}
		else {
			angularpage.Checkbox().click();
		} 
	}

	@When("Choose the Male option in Gender")
	public void choose_the_Male_option_in_Gender() {
	    
		System.out.println("Gender"+angularpage.Gender().toString());
		angularpage.Gender().selectByIndex(0);
	}

	@When("select the Employed radio button")
	public void select_the_Employed_radio_button() {
	    
		if(angularpage.Employment().isSelected()) {
			System.out.println("Employment radio button already selected");
		}
		else {
			angularpage.Employment().click();
		}
	}

	@When("choose the vaild date of birth {string}")
	public void choose_the_vaild_date_of_birth(String dob) {
	    
		angularpage.Date_of_Birth().click();
		angularpage.Date_of_Birth().sendKeys(dob);
	}

	@Then("click the submit button")
	public void click_the_submit_button() {
	    
		angularpage.Submit().click();
		waitForPageLoad();
		Assert.assertEquals(angularpage.SuccessMessage().getText(), "Success!");
	}
	
	@Given("open the automation practice page {string}")
	public void open_the_automation_practice_page(String url) throws IOException {
		driver.get(url);
		waitForPageLoad();
	}

	@When("Enter the name in alertbox {string}")
	public void enter_the_name_in_alertbox(String name) {
		
		automationpage = new AutomationPracticePage(driver);
		automationpage.AlertName().sendKeys(name);
	}

	@Then("Click the alert button")
	public void click_the_alert_button() throws Exception {
		
		automationpage.AlertButton().click();
		waitForPageLoad();
		
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
	}


}

