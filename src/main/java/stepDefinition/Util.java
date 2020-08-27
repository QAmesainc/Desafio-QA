package stepDefinition;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DriverContext;

import java.util.concurrent.TimeUnit;

public class Util {

    @Dado("que eu esteja na página do Wiktionary")
    public void AbrirNavegador()
    {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://en.wiktionary.org/");
        DriverContext.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Entao("fecho o navegador")
    public void FecharNavegador()
    {
        WebDriver driver = DriverContext.getDriver();
        driver.quit();
        DriverContext.setDriver(driver);
    }
}
