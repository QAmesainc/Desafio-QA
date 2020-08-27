package core;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import metodos.Gerais;
import metodos.Log;
import propriedades.Valores;

public class Driver {

	private static WebDriver webDriver = null;

	private Driver() {
		// Constructor
	}

	/*
	 * criarDriver()
	 * 
	 * Método responsável por criar o driver caso ele
	 * seja nulo.
	 * 
	 */
	public static void criarDriver() {

		// Mensagem de inicio
		Log.info("Iniciando criacao do WebDriver.");
		
		// -- Chrome --
		if (Gerais.capturarChaveProperties("browser").equalsIgnoreCase("chrome")) {

			Log.info("Browser: Chrome");
			
			File file = new File(Valores.getChromedriverLocal());
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions chOption = new ChromeOptions();
			chOption.addArguments("disable-gpu");
			ChromeDriver chromeDriver = new ChromeDriver(chOption);
			chromeDriver.manage().timeouts().implicitlyWait(
					Integer.parseInt(Gerais.capturarChaveProperties("ImplicitWaitTimeOut")), TimeUnit.SECONDS);
			webDriver = chromeDriver;

		// -- Firefox --
		} else {
			
			Log.info("Browser: Firefox");

			File file = new File(Valores.getGeckodriverLocal());
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			FirefoxOptions fxOptions = new FirefoxOptions();
			fxOptions.addArguments("acceptInsecureCerts");
			FirefoxDriver firefoxDriver = new FirefoxDriver(fxOptions);
			firefoxDriver.manage().timeouts().implicitlyWait(
					Integer.parseInt(Gerais.capturarChaveProperties("ImplicitWaitTimeOut")), TimeUnit.SECONDS);
			webDriver = firefoxDriver;
		}

		// Mensagem de inicio
		Log.info("WebDriver criado com sucesso.");
	}

	/*
	 * getDriver()
	 * 
	 * Retorno do driver dentro da classe, sera criado caso seja nulo.
	 * 
	 */
	public static WebDriver getDriver() {
		if (webDriver == null) {
			criarDriver();
		}
		return webDriver;

	}

	/*
	 * fecharDriver()
	 * 
	 * Método responsável por encerrar o driver caso ele
	 * nao seja nulo.
	 * 
	 */
	public static void fecharDriver() {

		// Caso o driver nao seja nulo ele sera fechado
		if (webDriver != null) {
			Log.info("Realizando fechamento do WebDriver.");
			webDriver.quit();
			webDriver = null;
		}

	}

}
