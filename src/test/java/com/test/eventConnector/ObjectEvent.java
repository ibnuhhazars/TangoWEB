package com.test.eventConnector;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

public class ObjectEvent {

	public WebDriver driver;

	public void openEvent(String text) throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setPlatform(Platform.LINUX);
		cap.setBrowserName("chrome");
		cap.setVersion("68.0");
		cap.setCapability("enableVNC", true);
		cap.setCapability("enableVideo", false);

		URL url = new URL("http://localhost:4444/wd/hub");
		
		setDriver(new RemoteWebDriver(url, cap));
		getDriver().get(text);
		getDriver().manage().window().setSize(new Dimension(1920, 1080));
		
	}

	public void setTextEvent(String text, String objectName) {
		getDriver().findElement(By.id(objectName)).sendKeys(text);
	}

	public void checkElementEvent(String objectName) {
		getDriver().findElement(By.id(objectName)).click();
	}

	public void radioElementEvent(String objectName) {
		getDriver().findElement(By.id(objectName)).click();
	}

	public void dropdownElementEvent(String text, String objectName) throws InterruptedException {
		WebElement fieldSortBy = driver.findElement(By.id(objectName));
		Select selectedItem = new Select(fieldSortBy);
		Thread.sleep(1000);
		selectedItem.selectByVisibleText(text);
	}

	public void sliderEvent(String text, String objectName) {
		WebElement slider = getDriver().findElement(By.id(objectName));
		WebElement rate = null;

		switch (text) {
		case ("2"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[2]"));
			break;
		case ("3"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[3]"));
			break;
		case ("4"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[4]"));
			break;
		case ("5"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[5]"));
			break;
		case ("6"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[6]"));
			break;
		case ("7"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[7]"));
			break;
		case ("8"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[8]"));
			break;
		case ("9"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[9]"));
			break;
		case ("10"):
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[10]"));
			break;
		default:
			rate = getDriver().findElement(By.xpath("//*[@id='main-form']/div/div[2]/fieldset[2]/div/div[2]/div[1]"));
		}

		Actions action = new Actions(getDriver());
		action.clickAndHold(slider).moveToElement(rate).release(rate).build().perform();
	}

	public void clickEvent(String objectName) {
		getDriver().findElement(By.id(objectName)).click();
	}

	public void verifyLabelEvent(String objectName, String text) throws InterruptedException {
		String getText = getDriver().findElement(By.id(objectName)).getText();
		AssertJUnit.assertEquals(text, getText);
	}

	public void verifyClickableEvent(String objectName) {
		String actualAtributDisable = getDriver().findElement(By.id(objectName)).getAttribute("disabled").toString();
		AssertJUnit.assertEquals("true", actualAtributDisable);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
