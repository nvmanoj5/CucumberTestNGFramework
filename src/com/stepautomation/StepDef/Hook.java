package com.stepautomation.StepDef;


import com.testautomation.Utility.Baseproperty;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.ast.Scenario;

public class Hook  extends Baseproperty{
	
	
	public static String scenarioname;
	
	public Baseproperty base;
	
	public Hook(Baseproperty base) {
		
		this.base = base;
	}
	
	@Before
	public void initializetest() {
		
		//System.out.println("Hook initializetest ");
	}
	
	@After
	public void TearDownTest(cucumber.api.Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			scenarioname  =	scenario.getName();	
			/*System.out.println("Hook Scenario name fail: "+scenario.getName());
			
			System.out.println("Hook Scenario name2 fail : "+scenarioname);*/
		}
		else{
			
			scenarioname  =	scenario.getName();	
		}
	}
	
	

}
