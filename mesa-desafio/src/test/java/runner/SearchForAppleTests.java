package runner;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObjects.WikiMainPage;

public class SearchForAppleTests {
	public WebDriver driver;
	public WikiMainPage WikiMainPageObject;
	

	@Before
	public void setUp() {
		driver = DriverManager.getDriver();
		WikiMainPageObject = new WikiMainPage(driver);
		
	}
	
	@Test
	public void searchForAppleLowKey() {
		WikiMainPageObject.inputCentralSearchField().sendKeys("apple");
		WikiMainPageObject.clickLookUpButton();
		assertTrue(WikiMainPageObject.verifyHeadResult().equals("apple"));
		assertTrue(WikiMainPageObject.verifyappleNounDefinition().contains("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates."));
		
	}
	
	
	@Test
	public void searchForAppleUpperKey() {
		WikiMainPageObject.clickMainPageLink();
		WikiMainPageObject.inputCentralSearchField().sendKeys("Apple");
		WikiMainPageObject.clickLookUpButton();
		assertTrue(WikiMainPageObject.verifyHeadResult().equals("Apple"));
		assertFalse(WikiMainPageObject.verifyAppleNounDefinition().contains("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates."));
	}
	
	@After
	public void tearDown() {
		driver.quit();

}
}
