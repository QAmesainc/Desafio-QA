package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
	public static WebDriver driver;

	
	public DriverManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}


	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "/Users/ewerttonoliveira/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			String homeWikiUrl = "https://en.wiktionary.org/";
			driver.get(homeWikiUrl);
			return driver;
}
		return driver;
}
}