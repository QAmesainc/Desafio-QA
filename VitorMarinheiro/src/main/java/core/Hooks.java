package core;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import metodos.Gerais;

public class Hooks {
	
	// executado antes de cada cenario
	@Before
	public void setUpCenario(Scenario cenario) {
		
		// Cria os diretorios de execucao do fluxo
		Gerais.criarSubdiretoriosDeExecucao(cenario.getName());
		
	}

	// executado depois de cada cenario
	@After
	public void tearDownCenario(Scenario cenario) {

		// Fecha o driver
		Driver.fecharDriver();
		
		// Monta o PDF de evidencias do fluxo
		Gerais.montarEvidenciaPDF(cenario.getName());
		
	}
	
}
