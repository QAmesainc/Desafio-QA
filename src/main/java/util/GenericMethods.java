package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
    public static void waitPageLoad() {
            WebDriver driver = DriverContext.getDriver();
            new WebDriverWait(driver,60).until(webDriver -> ((JavascriptExecutor) webDriver))
                    .executeScript("return document.readState").equals("complete");
    }
}
