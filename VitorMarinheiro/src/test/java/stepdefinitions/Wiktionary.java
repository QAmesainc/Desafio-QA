package stepdefinitions;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.WikitionaryHomePage;
import pages.WikitionaryResultPage;
import propriedades.Valores;
import core.Driver;
import io.cucumber.java.pt.Dado;

public class Wiktionary {

	@Dado("que foi acessado o site {string}")
	public void queFoiAcessadoOSite(String url) {

		// Salva a URL para ser usada no PDF de evidencias
		Valores.setUrl(url);
		
		// Acessa o site recebido por parametro
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(url);

		// Validar apresentacao da pagina home
		new WikitionaryHomePage(Driver.getDriver()).validarApresentacaoDaPagina();

	}

	@Quando("for realizada uma busca no campo Look up pela palavra {string}")
	public void forRealizadaUmaBuscaNoCampoLookUpPelaPalavra(String busca) {
		new WikitionaryHomePage(Driver.getDriver()).pesquisarPalavaChave(busca);
	}

	@Entao("uma das definicoes contem o conteudo {string}")
	public void umaDasDefinicoesContemOConteudo(String definicao) {
		new WikitionaryResultPage(Driver.getDriver()).validarApresentacaoDeDefinicao(definicao);
	}

}
