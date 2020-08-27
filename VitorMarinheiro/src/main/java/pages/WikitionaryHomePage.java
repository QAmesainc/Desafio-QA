package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import metodos.Gerais;
import metodos.Log;

/* 
 * Page referente 'a pagina inicial do Wiktionary
 */
public class WikitionaryHomePage {

	public WikitionaryHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "search")
	public WebElement campoBusca;
	

	/*
	 * Metodos utilizados
	 */
	
	// Valida que a pagina home da Wiki foi apresentada corretamente
	public void validarApresentacaoDaPagina() {
		try {
			campoBusca.isDisplayed();
			Gerais.takeScreenShot("Pagina home foi apresentada corretamente.");
		} catch (Exception e) {
			Gerais.takeScreenShot("Pagina home nao foi apresentada corretamente.");
			Log.error("A pagina home nao foi carregada corretamente.");
			Assert.fail("A pagina home nao foi carregada corretamente.");
		}
	}

	// Pesquisar por palavra chave
	public void pesquisarPalavaChave(String chave) {
		campoBusca.sendKeys(chave);
		Gerais.takeScreenShot("Busca pela palavra chave '"+chave+"'.");
		campoBusca.submit();
	}
}
