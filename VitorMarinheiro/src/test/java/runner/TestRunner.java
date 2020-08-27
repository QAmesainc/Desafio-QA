package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import metodos.Gerais;

/*
 * Definição das funcionalidades das Options do cucumber:
 *
 * plugin -> Possui o plugin "pretty" responsável por exibir o detalhamento da
 * execução cucumber no console, e a configuração do report integrado entre o
 * LeanFT e Cucumber.
 * 
 * features -> Configuração do path onde se encontram as features do projeto.
 * 
 * glue -> Configuração do path onde se encontram as StepsDefinitions do
 * projeto. Pode manter como está.
 * 
 * tags -> Local onde podemos definir as tags responsáveis por controlar a
 * execução das features e cenários.
 * 
 * monochrome -> Caso o projeto seja executado via linha de comando necessário
 * estar como True, pois essa propriedade estrutura o spool de execução com
 * cores. Caso a execução seja via Eclipse é necessário manter como False.
 * 
 * dryRun -> Por default é False. Caso alterarmos para True, o projeto não irá
 * executar o conteúdo das steps definitios, serão executados apenas a estrutura
 * da feature. Necessário para validarmos apenas a geração dos métodos pelo
 * cucumber.
 * 
 * strict -> Por default é false, onde caso alguma assertiva gere erro, será
 * lançado uma "Failure" na execução do cenário. Mas o projeto não
 * ficará falhado. Se alterado para True, nessas condições o projeto ficará falhado.
 * 
 * snippets -> Padroniza a nomenclatura dos metodos gerados para as step
 * definitions. Configurado como CAMELCASE os metodos sao criados com o layout
 * "MetodoCenario01", caso nao utilizar essa option, os metodos sao criados com
 * o layout"Metodo_Cenario_01"
 *
 */

@CucumberOptions(plugin = {
		"json:target/cucumber-reports/Cucumber.json" }, features = "src/test/java/features", glue = "", tags = {
				"@Desafio" }, monochrome = false, dryRun = false, strict = false)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeClass	
	public static void setUpBeforeClass() {
		
		// Captura SO utilizada na execucao  (Ajustar comandos de utilizacao para o Docker)
		Gerais.capturarSO();
		
	}

	@AfterClass
	public static void tearDownAfterClass() {

		// Abre o explorer apontando para o arquivo gerado
		Gerais.abrirDiretorioDeEvidencias();
	}
	
}
