package pageObjects;

import runner.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WikiMainPage extends DriverManager {

	public WikiMainPage(WebDriver driver) {
		DriverManager.driver = driver;
	//System.out.println(driver);
	}
	
	public String getwikiMainPageTitle() {
		return driver.getTitle();
		}
	
	// Selectors
		private By centralSearchField = (By.name("search")); 
		private By lookUpButton = By.cssSelector("input.mw-ui-button");
		private By mainPageLink = By.cssSelector("#n-mainpage-text > a:nth-child(1)");
	    private By applenounDefinition = By.cssSelector(".mw-parser-output > ol:nth-child(12)"); 
	    private By cApplenounDefinition = By.cssSelector(".mw-parser-output > ol:nth-child(13)"); 
	    private By pearnounDefinition = By.cssSelector(".mw-parser-output > ol:nth-child(13)"); 
	    private By headResult = By.cssSelector("#firstHeading");
	   
	//Actions
	    public  WebElement inputCentralSearchField() {
	  	return driver.findElement(centralSearchField);
	        }
	    public void clickLookUpButton() {
			driver.findElement(lookUpButton).click();
	        }
	    public void clickMainPageLink() {
			driver.findElement(mainPageLink).click();
	        }
	   
	    
	    public String verifyappleNounDefinition() {
			return driver.findElement(applenounDefinition).getText();
	    }
	    
	    public String verifyAppleNounDefinition() {
	    	return driver.findElement(cApplenounDefinition).getText();
	    }
	    public String verifypearNounDefinition() {
	    	return driver.findElement(pearnounDefinition).getText();
	    }
	    
	    
	    public String verifyHeadResult() {
			return driver.findElement(headResult).getText();
	    }
			
}
