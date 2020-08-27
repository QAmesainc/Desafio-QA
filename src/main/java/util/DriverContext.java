package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverContext {


    private static WebDriver driver;



    public static WebDriver getDriver() {

        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverContext.driver = driver;

    }

}
