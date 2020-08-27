package propriedades;

import metodos.Gerais;

public class Valores {

	private Valores() {
		// Constructor
	}

	// DIRETORIOS
	private static String dirResourcesName = "/resources";
	private static String dirExecutaveisName = "/executaveis";
	private static String dirPropriedadesName = "/propriedades";
	private static String dirEvidenciasName = "/evidencias";
	private static String dirScreenshotsName = "/Screenshots";
	private static String dirLogsName = "/Logs";
	private static String dirEvidenciasExecucaoName = "/Evd_" + Gerais.obterDataFormatada("dd-MM-YYYY_HH.mm.ss");
	private static String dirScreenshotsDoCenario; // Diretorios preenchidos na hooks referentes as evidencias de cada cenario executado
	private static String dirLogsDoCenario; // Diretorios preenchidos na hooks referentes as evidencias de cada cenario executado

	// ARQUIVOS
	private static String fileProjectProperties = "project.properties";
	private static String fileChromeDriver = "chromedriver.exe";
	private static String fileGeckoDriver = "geckodriver.exe";
	private static String fileScreenshotsEvidenceName = "Screenshot_";
	private static String fileLogEvidenciasTXTName = "PassosEvidencia.txt";

	// Caminho do arquivo do Chromedriver no projeto
	private static String chromedriverLocal = System.getProperty("user.dir") + "/src" + dirResourcesName
			+ dirExecutaveisName + "/" + fileChromeDriver;

	// Caminho do arquivo do Geckodriver no projeto
	private static String geckodriverLocal = System.getProperty("user.dir") + "/src" + dirResourcesName
			+ dirExecutaveisName + "/" + fileGeckoDriver;

	// Caminho do arquivo de propriedades do projeto
	private static String projectPropertiesLocal = System.getProperty("user.dir") + "/src/main/java"
			+ dirPropriedadesName + "/" + fileProjectProperties;

	// Definindo o diretório padrão de evidencias que será criado a cada execução do
	// projeto.
	private static String dirEvidencias = System.getProperty("user.dir") + "/src" + dirResourcesName + dirEvidenciasName
			+ dirEvidenciasExecucaoName + "/";

	// Definindo o caminho para a imagem do cabecalho que sera utilizada como base
	// para o template de evidencias
	private static String fileImgCabecalho = System.getProperty("user.dir") + "/src" + dirResourcesName
			+ dirExecutaveisName + "/Cabecalho.png";

	private static String url;

	/*
	 * Getters and Setters
	 */

	public static String getChromedriverLocal() {
		return chromedriverLocal;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Valores.url = url;
	}

	public static String getFileScreenshotsEvidenceName() {
		return fileScreenshotsEvidenceName;
	}

	public static String getFileLogEvidenciasTXTName() {
		return fileLogEvidenciasTXTName;
	}

	public static String getGeckodriverLocal() {
		return geckodriverLocal;
	}

	public static String getProjectPropertiesLocal() {
		return projectPropertiesLocal;
	}

	public static String getDirEvidencias() {
		return dirEvidencias;
	}

	public static String getDirScreenshotsName() {
		return dirScreenshotsName;
	}

	public static String getDirLogsName() {
		return dirLogsName;
	}

	public static String getDirScreenshotsDoCenario() {
		return dirScreenshotsDoCenario;
	}

	public static void setDirScreenshotsDoCenario(String dirScreenshotsDoCenario) {
		Valores.dirScreenshotsDoCenario = dirScreenshotsDoCenario;
	}

	public static String getDirLogsDoCenario() {
		return dirLogsDoCenario;
	}

	public static void setDirLogsDoCenario(String dirLogsDoCenario) {
		Valores.dirLogsDoCenario = dirLogsDoCenario;
	}

	public static String getFileImgCabecalho() {
		return fileImgCabecalho;
	}

}
