package runner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObjects.WikiMainPage;

public class OpenPage {
	public WebDriver driver;
	public WikiMainPage WikiMainPageObject;
	

	@Test
	public void setUp() {
		driver = DriverManager.getDriver();
		WikiMainPageObject = new WikiMainPage(driver);
		
	}
}