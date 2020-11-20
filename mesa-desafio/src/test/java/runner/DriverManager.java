package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverManager {
	public static WebDriver driver;
	private static WebDriverWait wait;

	
	//public DriverManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//}


	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "/Users/ewerttonoliveira/git/Desafio-QA/mesa-desafio/src/test/resources/geckodriver"); 
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			String homeWikiUrl = "https://en.wiktionary.org/";
			driver.get(homeWikiUrl);
			return driver;
}
		return driver;
	}	
		public static WebDriverWait getWait() {
			if (wait == null) {
				wait = new WebDriverWait(getDriver(), 20);
			}
			return wait;
		}
		public static void endSession() {
			if (driver != null) {
				driver.quit();
				driver = null;
				wait = null;
			}
		}
}
