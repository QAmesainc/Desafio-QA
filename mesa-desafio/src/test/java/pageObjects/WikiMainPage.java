package pageObjects;

//import java.sql.DriverManager;
import runner.core;
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
}