package runner;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageObjects.WikiMainPage;

public class SearchForPearTests {
	public WebDriver driver;
	public WikiMainPage WikiMainPageObject;
	

	@Before
	public void setUp() {
		driver = DriverManager.getDriver();
		WikiMainPageObject = new WikiMainPage(driver);
		
	}
	
	@Test
	public void searchForPear() {
	 	WikiMainPageObject.inputCentralSearchField().sendKeys("pear");
		WikiMainPageObject.clickLookUpButton();
		assertTrue(WikiMainPageObject.verifyHeadResult().equals("pear"));
		assertTrue(WikiMainPageObject.verifypearNounDefinition().contains("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem."));
	}
	
	
	
	
	
	@After
	public void afterScenario() {
		DriverManager.endSession();
	}

}
