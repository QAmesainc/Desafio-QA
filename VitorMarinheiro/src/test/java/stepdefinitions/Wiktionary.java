package stepdefinitions;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Dado;

public class Wiktionary {

	@Dado("que foi acessado o site {string}")
	public void queFoiAcessadoOSite(String URL) {
	}

	@Quando("for realizada uma busca no campo Look up pela palavra {string}")
	public void forRealizadaUmaBuscaNoCampoLookUpPelaPalavra(String busca) {
	}

	@Entao("uma das definicoes contem o conteudo {string}")
	public void umaDasDefinicoesContemOConteudo(String contexto) {
	}

}
