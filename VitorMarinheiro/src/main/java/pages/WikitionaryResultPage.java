package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import metodos.Gerais;
import metodos.Log;

/* 
 * Page referente 'a pagina de resultado da busca do Wiktionary
 */
public class WikitionaryResultPage {

	public WikitionaryResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Captura dinamica via xpath das linhas de definicao da palavra chave
	@FindBy(how = How.XPATH, using = "//*[@id=\"Noun\"]/following::ol[1]/li")
	List<WebElement> definicoes;

	/*
	 * Metodos utilizados
	 */

	// Pesquisar por palavra chave
	public void validarApresentacaoDeDefinicao(String definicao) {

		// Varre a lista de definicoes
		boolean encontrado = false;
		for (int i = 0; i < definicoes.size(); i++) {

			// Caso a definicao correta seja encontrada
			if (definicoes.get(i).getText().contains(definicao)) {
				Log.info("Definicao encontrada com sucesso no indice: " + (i + 1) + ".");
				
				// Foca no elemento para captura de evidencia
				Gerais.takeScreenShot("Descricao encontrada.", definicoes.get(i));
				
				// Sai do loop de busca
				encontrado = true;
				break;
			}

		}
		
		// Validar caso nao tenha encontrado uma definicao correspondente
		if(!encontrado) {
			Log.error("A definicao recebida nao foi encontrada na pagina de resultado: "+definicao);
			Assert.fail("A definicao recebida nao foi encontrada na pagina de resultado: "+definicao);
		}
	}

}
