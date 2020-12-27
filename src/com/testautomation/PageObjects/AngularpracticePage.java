package com.testautomation.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularpracticePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AngularpracticePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
	}
	
	@FindBy(xpath="//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement Nme;
	
	@FindBy(xpath="//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[2]/input[1]")
	WebElement mail;
	
	@FindBy(css="#exampleInputPassword1")
	WebElement pwd;
	
	@FindBy(css="#exampleCheck1")
	WebElement chkbx;
	
	@FindBy(xpath="//select[@id='exampleFormControlSelect1']")
	WebElement gendr;
	
	@FindBy(xpath="//input[@id='inlineRadio2']")
	WebElement emplymnt;
	
	@FindBy(xpath="//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[7]/input[1]")
	WebElement dob;
	
	@FindBy(xpath="//body/app-root[1]/form-comp[1]/div[1]/form[1]/input[1]")
	WebElement submitbutton;
	
	@FindBy(xpath="//strong[contains(text(),'Success!')]")
	WebElement successmsg;
	
	
	public WebElement Name() {
		
		return Nme;
	}
	
	public WebElement Email() {
		
		return mail;
	}
	
	public WebElement Password() {
	
		return pwd;
	}
	
	public WebElement Checkbox() {
		
		return chkbx;
	}
	
	public Select Gender(){
		
		return new Select(gendr);
	}
	
	public WebElement Employment() {
		
		return emplymnt;
	}
	
	public WebElement Date_of_Birth() {
		
		return dob;
	}
	
	public WebElement Submit() {
		
		return submitbutton;
	}
	
	public WebElement SuccessMessage() {
		
		return successmsg;
	}
	

}
