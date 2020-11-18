package pageObjects;

import runner.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WikiMainPage extends DriverManager {

	public WikiMainPage(WebDriver driver) {
		super(driver);
	}
	
	public String getwikiMainPageTitle() {
		return driver.getTitle();
		
	}
	// Selectors
		private static By centralSearchField = By.cssSelector("#bodySearchInput0\\.059829490412"); 
		private static By lookUpButton = By.cssSelector("input.mw-ui-button");
	    private static By nounDefinition = By.cssSelector(".mw-parser-output > ol:nth-child(12)"); 
	    private static By headResult = By.cssSelector("#firstHeading");
	
	//Actions
	    
	    public  WebElement CentralSearchField() {
	    	return driver.findElement(centralSearchField);
	        }
	    public void ClickLookUpButton() {
			driver.findElement(lookUpButton).click();
	        }
	    public String VerifyNounDefinition() {
			return driver.findElement(nounDefinition).getText();
	    }
	    public String VerifyHeadResult() {
			return driver.findElement(headResult).getText();
	    }
			
}
