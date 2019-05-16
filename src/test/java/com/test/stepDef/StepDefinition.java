package com.test.stepDef;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.eventConnector.ObjectEvent;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends ObjectEvent {
	
	private Scenario myScenario;
	
	@Before
	public void before(Scenario scenario) {
		myScenario = scenario;
	}
	
	@Given(".*?open.*? \"(.*?)\"$")
	public void openApps(String text) throws MalformedURLException {
		openEvent(text);
	}
	
	@Given(".*?click.*? \"(.*?)\"$")
	public void click(String objectName) {
		clickEvent(objectName);
	}
	
	@When(".*?enter.*? \"(.*?)\" in \"(.*?)\"$")
	public void setTextby(String text, String objectName) throws InterruptedException {
		setTextEvent(text, objectName);
	}
	
	@When(".*?checklist.*? \"(.*?)\"$")
	public void checkElement(String objectName) {
		checkElementEvent(objectName);
	}
	
	@When(".*?chose.*? \"(.*?)\"$")
	public void radioElement(String objectName) {
		radioElementEvent(objectName);
	}
	
	@When(".*?select.*? \"(.*?)\" in \"(.*?)\"$")
	public void dropdownElement(String text, String objectName) throws InterruptedException {
		dropdownElementEvent(text, objectName);
	}
	
	@When("^i give rate as \"(.*?)\" in \"(.*?)\"$")
	public void i_give_rate_as_in_slider(String text, String objectName) {
	   sliderEvent(text, objectName);
	}
	
	@Then(".*?verify.*? \"(.*?)\" is \"(.*?)\"$")
	public void verifyLabel(String objectName, String text) throws InterruptedException {
		verifyLabelEvent(objectName, text);
	}
	
	@Then(".*?verify.*? \"(.*?)\" is not clickable")
	public void verifyClickable(String objectName) {
		verifyClickableEvent(objectName);
	}
	
	@After
	public void after() throws InterruptedException {
		
		if (myScenario.isFailed()) {
			myScenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
			myScenario.write("Scenario Fail");
		} else {
			myScenario.write("Scenario Pass");
		}
		
		Thread.sleep(2000);
		
		getDriver().close();
	}
}
