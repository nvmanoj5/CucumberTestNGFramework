package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AutomationPracticePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
	}
	
	@FindBy(xpath="//input[@id='name']")
	WebElement alrtNme;
	
	@FindBy(xpath="//input[@id='alertbtn']")
	WebElement alertbtn;
	
	public WebElement AlertName() {
		
		return alrtNme;
	}
	
	public WebElement AlertButton() {
		
		return alertbtn;
	}

}
