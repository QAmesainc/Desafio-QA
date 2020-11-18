package runner;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObjects.WikiMainPage;

public class SearchForApple {
	public WebDriver driver;
	public WikiMainPage WikiMainPageObject;
	

	@Before
	public void setUp() {
		driver = DriverManager.getDriver();
		WikiMainPageObject = new WikiMainPage(driver);
		
	}
	
	@Test
	public void searchForAppleLowKey() {
		WikiMainPageObject.CentralSearchField().sendKeys("apple");
		WikiMainPageObject.ClickLookUpButton();
		assertTrue(WikiMainPageObject.VerifyHeadResult().equals("apple"));
		assertTrue(WikiMainPageObject.VerifyNounDefinition().contains("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates."));
	}

	
	
	@After
	public void tearDown() {
		driver.quit();

}
}
