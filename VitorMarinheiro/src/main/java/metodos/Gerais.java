package metodos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import core.Driver;
import propriedades.Valores;

public class Gerais {

	private Gerais() {
		// Constructor
	}

	/*
	 * Função: capturarChaveProperties(String chave)
	 * 
	 * Metodo utilizado para capturar o valor da chave (recebida por parametro)
	 * dentro do arquivo .properties do projeto.
	 * 
	 */
	public static String capturarChaveProperties(String chave) {

		// Abre o Input apontando para o arquivo de properties
		try (InputStream input = new FileInputStream(Valores.getProjectPropertiesLocal())) {

			// Inicia as propriedades
			Properties prop = new Properties();

			// Carrega o arquivo
			prop.load(input);

			// Captura a chave recebida por parametro e retorna
			return prop.getProperty(chave);

		} catch (IOException e) {
			Log.error(e.toString());
			return null;
		}
	}

	/*
	 * Função: capturarSO()
	 * 
	 * Metodo utilizado para capturar dinamicamente o Sistema Operacional em que a
	 * automacao esta sendo executada.
	 * 
	 */
	public static void capturarSO() {

		// -- Windows --
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {

			Log.info("SO Utilizado: Windows");

			// -- Linux --
		} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {

			Log.info("SO Utilizado: Linux");

		} else {
			Log.info("SO Utilizado: MacOs");
		}

	}

	/*
	 * Função: criarDiretorio(String caminho) Realiza a criaçao de diretorios
	 * 
	 * Parametros:
	 * 
	 * String caminho -> Recebera o valor do diretorio que deve ser criado
	 * 
	 */
	public static void criarDiretorio(String caminho) {
		new File(caminho).mkdirs();
	}

	/*
	 * Função: takeScreenShot()
	 * 
	 * Função responsável por fazer screenshots da tela. O Screenshot está sendo
	 * salvo no diretório de evidencias do projeto em execução.
	 * 
	 * Parametros:
	 * 
	 * String Descricao: String que será utilizada para alterar o txt de descricao
	 * dos prints e ser utilizada para inserir a descricao dos prints dentro do
	 * arquivo .pdf
	 */
	public static void takeScreenShot(String descricao) {

		// Converte o remoteDesktop para o objeto de Screenshot
		TakesScreenshot scrShot = ((TakesScreenshot) Driver.getDriver());

		// Usa o objeto screenshot para criar o arquivo
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Configuração do arquivo
		wait(1000);   // Evitar duplicidade de prints em mesmo segundo
		String arquivoScreenshot = Valores.getDirScreenshotsDoCenario() + "/" + Valores.getFileScreenshotsEvidenceName()
				+ obterDataFormatada("dd-MM-YYYY_HH.mm.ss."+gerarNumeroRandomicoComNDigitos(2)) + ".png";

		// Move a imagem para o novo destino
		File destFile = new File(arquivoScreenshot);

		// Copia o arquivo
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			Log.error("Erro ao retirar o print da imagem: " + arquivoScreenshot);
		}

		// Valida que se o usuario inseriu uma mensagem em branco
		if (descricao.trim().equals("")) {
			// Insere a linha de Log no arquivo de Log
			adicionarLinhaEmArquivoTxt(Valores.getDirLogsDoCenario() + "/" + Valores.getFileLogEvidenciasTXTName(),
					" ");
		} else {
			// Insere a linha de Log no arquivo de Log
			adicionarLinhaEmArquivoTxt(Valores.getDirLogsDoCenario() + "/" + Valores.getFileLogEvidenciasTXTName(),
					descricao);
		}

	}

	public static void takeScreenShot(String descricao, WebElement element) {

		// Realiza o HighLigh no elemento
		focusElemento(element, 0);
		highLightTrue(element);

		// Captura a evidencia
		takeScreenShot(descricao);

		// Desativa o HighLight
		highLightFalse(element);
	}

	/*
	 * Função: highLightTrue
	 * 
	 * Realiza o HighLight no elemento recebido como parametro para facilitar
	 * visualizacao do fluxo.
	 * 
	 * Parametros:
	 * 
	 * WebElement element -> Elemento que sera usado.
	 * 
	 */
	public static void highLightTrue(WebElement element) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 10px solid red;");
			wait(400);
		} catch (Exception e) {
			Log.warn("Nao foi possivel realizar o highligh no elemento.");
		}

	}

	/*
	 * Função: highLightFalse
	 * 
	 * Desativa o HighLight no elemento recebido como parametro para facilitar
	 * visualizacao do fluxo.
	 * 
	 * Parametros:
	 * 
	 * WebElement element -> Elemento que sera usado.
	 * 
	 */
	public static void highLightFalse(WebElement element) {

		try {
			wait(200);
			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		} catch (Exception e) {
			Log.warn("Nao foi possivel desativar o highligh no elemento.");
		}

	}

	/*
	 * Função: obterDataFormatada()
	 * 
	 * Função realiza a busca da data e hora atual do sistema e retorna como String
	 * com o layout passado por parametro,
	 * 
	 * Exemplo: "dd-MM-YYYY_HH.mm.ss"
	 * 
	 */
	public static String obterDataFormatada(String layout) {

		// Criação das Variáveis
		Date dataAtual;
		String dataAtualFormatada;

		// Instanciando objetos
		DateFormat format = new SimpleDateFormat(layout);

		// Setando valores nas variáveis
		dataAtual = new Date();
		dataAtualFormatada = format.format(dataAtual);

		return dataAtualFormatada;
	}

	/*
	 * Função: adicionarLinhaEmArquivoTxt
	 * 
	 * Realiza a escrita de uma linha recebida por parametro em um arquivo de texto
	 * tambem recebido por parametro. Caso o arquivo nao exista, ele sera criado.
	 * 
	 * Parametros:
	 * 
	 * String Arquivo -> Aponta para o caminho do arquivo que sera editado/criado.
	 * Strint Linha -> String de linha que sera escrita no arquivo.
	 * 
	 */
	public static void adicionarLinhaEmArquivoTxt(String arquivo, String linha) {

		// Valida existencia do arquivo
		if (!new File(arquivo).exists()) {
			Log.warn("Arquivo " + arquivo + " nao existe atualmente e sera criado.");
		}

		// Escreve no arquivo
		try (FileWriter fw = new FileWriter(arquivo, true)) {

			// Caso o arquivo esteja vazio, adiciona na primeira linha
			if (new String(Files.readAllBytes(Paths.get(arquivo))).equals("")) {
				fw.write(linha);

				// Caso o arquivo nao esteja vazio, adiciona uma quebra de linha
			} else {
				fw.write("\n" + linha);
			}

		} catch (IOException e) {
			Log.error("Erro ao abrir o Arquivo de Texto: " + arquivo);
		}

	}

	/*
	 * Função: criarSubdiretoriosDeExecucao(Scenario cenarioName) Responsável por
	 * criar dinamicamente as pastas de evidencias de Screenshots e logs na pasta
	 * dos respectivos cenários do projeto em execução. Este método está sendo
	 * executado antes das execuções dos cenários.
	 * 
	 * Parametros:
	 * 
	 * Scenario cenarioName -> Receberá a descrição do cenário.
	 * 
	 */
	public static void criarSubdiretoriosDeExecucao(String cenarioName) {

		// Criação do diretório de Screenshots
		Valores.setDirScreenshotsDoCenario(
				Valores.getDirEvidencias() + "/" + cenarioName + Valores.getDirScreenshotsName());

		try {
			Gerais.criarDiretorio(Valores.getDirScreenshotsDoCenario());
		} catch (Exception e) {
			Log.error("Erro ao tentar criar o diretório de Screenshots: " + Valores.getDirScreenshotsDoCenario());
			Assert.fail("Erro ao tentar criar o diretório de Screenshots: " + Valores.getDirScreenshotsDoCenario());
		}

		// Criação do diretório de Logs
		Valores.setDirLogsDoCenario(Valores.getDirEvidencias() + "/" + cenarioName + Valores.getDirLogsName());

		try {
			Gerais.criarDiretorio(Valores.getDirLogsDoCenario());
			PrintWriter writer = new PrintWriter(
					Valores.getDirLogsDoCenario() + "/" + Valores.getFileLogEvidenciasTXTName(), "UTF-8");
			writer.close();
		} catch (Exception e) {
			Log.error("Erro ao tentar criar o diretório de Logs: " + Valores.getDirLogsDoCenario() + "/"
					+ Valores.getFileLogEvidenciasTXTName());
			Assert.fail("Erro ao tentar criar o diretório de Logs: " + Valores.getDirLogsDoCenario() + "/"
					+ Valores.getFileLogEvidenciasTXTName());
		}

	}

	/*
	 * Função: setPara()
	 * 
	 * Funcao de apoio para escrita do montarEvidenciaPDF(), ela serve para criacao
	 * de um paragrafo dinamico apontando para um local especifico da pagina.
	 * 
	 */
	public static void setPara(PdfContentByte canvas, Phrase p, float x, float y) {

		// Valida que o texto possui mais de 105 caracteres
		if (p.getContent().length() > 105) {

			// Cria a lista de Linhas
			ArrayList<String> linhasParaTexto = new ArrayList<>();

			// Captura a quantidade de linhas que serao necessarias
			int linhas = ((p.getContent().length() / 105) + 1);

			// Varre as linhas
			int indexInicial = 0;
			int indexFinal = 105;
			for (int i = 0; i < linhas; i++) {

				// Captura a linha atual
				linhasParaTexto.add(p.getContent().substring(indexInicial, indexFinal));

				// Aponta para o inicio da proxima linha
				indexInicial = indexFinal + 1;

				// Aponta para o final da proxima linha
				if (i + 2 == linhas) {
					indexFinal = p.getContent().length();
				} else {
					indexFinal = indexFinal + 105;
				}

			}

			// Insere os paragrafos no PDF
			for (int i = 0; i < linhasParaTexto.size(); i++) {
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(linhasParaTexto.get(i), p.getFont()),
						x, y - (10 * i), 0);
			}

		} else {
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, p, x, y, 0);
		}
	}

	/*
	 * Função: montarEvidenciaPDF()
	 * 
	 * Cria o PDF de evidencias utilizando o template e captura todos os parametros
	 * dentro da propria funcao. Necessario que a imagem do cabecalho se encontre no
	 * projeto.
	 * 
	 */
	public static void montarEvidenciaPDF(String name) {

		// Realiza a captura de todos os prints
		List<String> prints = listarArquivosDeDiretorio(new File(Valores.getDirScreenshotsDoCenario()));
		Document document = new Document();

		// Arquivo final
		String fileName = Valores.getDirEvidencias() + name;

		// Fontes criadas
		Font titFont = new Font(Font.FontFamily.COURIER, 13, Font.BOLD);
		Font resFont = new Font(Font.FontFamily.COURIER, 13, Font.NORMAL);
		Font comentFont = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
		Font infFont = new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD);
		infFont.setColor(BaseColor.WHITE);
		Font infDesc = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
		infDesc.setColor(BaseColor.WHITE);

		// Captura os Logs de evidencias
		List<String> linhasDeLog = leituraArquivoTexto(
				Valores.getDirLogsDoCenario() + "/" + Valores.getFileLogEvidenciasTXTName());

		try {

			// Gera a instancia dinamica do documento
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(new File(fileName.concat("//") + name + ".pdf")));

			// Abre o arquivo PDF
			document.open();

			// Adiciona a quebra de linha
			Paragraph newLine = new Paragraph();
			newLine.add(" ");
			newLine.setAlignment(Element.ALIGN_CENTER);
			for (int i = 0; i < 11; i++) {
				document.add(newLine);
			}

			// Insere o cabecalho
			Image cab = Image.getInstance(Valores.getFileImgCabecalho());
			cab.scaleAbsolute(500, 150);
			cab.setAbsolutePosition(50f, 650f);
			document.add(cab);

			// Insere a Informacao do cabecalho
			PdfPTable tableInformacoes = new PdfPTable(1);
			tableInformacoes.setWidthPercentage(93);
			PdfPCell cellInformacoes = new PdfPCell(new Paragraph("Informações do Cenário", infFont));
			cellInformacoes.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellInformacoes.setVerticalAlignment(Element.ALIGN_CENTER);
			cellInformacoes.setBackgroundColor(new BaseColor(151, 0, 10));
			tableInformacoes.addCell(cellInformacoes);
			document.add(tableInformacoes);

			// Inseres os dados
			PdfPTable tabelaDeDados = new PdfPTable(4);
			tabelaDeDados.setWidthPercentage(93);
			PdfPCell cell1 = new PdfPCell(new Paragraph("Site/Sistema", titFont));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Wiki", resFont));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Ambiente", titFont));
			PdfPCell cell4 = new PdfPCell(new Paragraph(Valores.getUrl(), resFont));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Responsável", titFont));
			PdfPCell cell6 = new PdfPCell(new Paragraph("Automação", resFont));
			PdfPCell cell7 = new PdfPCell(new Paragraph("Data", titFont));
			PdfPCell cell8 = new PdfPCell(
					new Paragraph(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()), resFont));

			// Setando alinhamento
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);

			// Adicionando as celulas dentro da tabela
			tabelaDeDados.addCell(cell1);
			tabelaDeDados.addCell(cell2);
			tabelaDeDados.addCell(cell3);
			tabelaDeDados.addCell(cell4);
			tabelaDeDados.addCell(cell5);
			tabelaDeDados.addCell(cell6);
			tabelaDeDados.addCell(cell7);
			tabelaDeDados.addCell(cell8);

			// Insere as tabelas no Documento
			document.add(tabelaDeDados);
			document.add(newLine);

			// Insere a Informacao do cabecalho
			PdfPTable tableDescricao = new PdfPTable(1);
			tableDescricao.setWidthPercentage(93);
			PdfPCell cellDescricao = new PdfPCell(new Paragraph("DETALHES - Cenário", infDesc));
			cellDescricao.setVerticalAlignment(Element.ALIGN_CENTER);
			cellDescricao.setBackgroundColor(new BaseColor(151, 0, 10));
			tableDescricao.addCell(cellDescricao);
			document.add(tableDescricao);

			// Insere a descricao do cenario
			PdfPTable tableResumoCenario = new PdfPTable(2);
			tableResumoCenario.setWidthPercentage(93);
			tableResumoCenario.setWidths(new float[] { 1, 3 });
			PdfPTable tableNomeCenario = new PdfPTable(2);
			tableNomeCenario.setWidthPercentage(93);
			tableNomeCenario.setWidths(new float[] { 1, 3 });
			PdfPCell cellTitNomeCenario = new PdfPCell(new Paragraph("Título", titFont));
			PdfPCell cellRespNomeCenario = new PdfPCell(new Paragraph(name, resFont));
			PdfPCell cellTitDescricao = new PdfPCell(new Paragraph("Descrição", titFont));
			PdfPCell cellRespDescricao = new PdfPCell(
					new Paragraph("Execução automatizada do cenário de teste " + name + ".", resFont));

			// Setando alinhamento
			cellTitDescricao.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitDescricao.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellRespDescricao.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellRespDescricao.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellRespNomeCenario.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellRespNomeCenario.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cellTitNomeCenario.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellTitNomeCenario.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// Insere as Celulas
			tableNomeCenario.addCell(cellTitNomeCenario);
			tableNomeCenario.addCell(cellRespNomeCenario);
			tableResumoCenario.addCell(cellTitDescricao);
			tableResumoCenario.addCell(cellRespDescricao);

			// Insere as tabelas no Documento
			document.add(tableNomeCenario);
			document.add(tableResumoCenario);

			// Realiza a leitura das imagens
			int images = 0;
			for (String string : prints) {

				// Captura a imagem
				Image image1 = Image.getInstance(string);

				// Seta a escala
				image1.scaleAbsolute(500, 200);

				if (images == 0) {

					// Fixa a posicao
					image1.setAbsolutePosition(50f, 250f);

					// Insere no PDF
					document.add(image1);

					// Insere o log da imagem
					setPara(writer.getDirectContent(), new Phrase(linhasDeLog.get(images), comentFont), 50,
							image1.getAbsoluteY() - 15);

					// Cria uma nova pagina
					document.newPage();

					// Insere a Informacao do cabecalho
					document.add(tableDescricao);
					document.add(tableNomeCenario);

				} else {

					// Diferencia a imagem para quebra de pagina
					if (images % 2 == 0) {

						// Fixa a posicao
						image1.setAbsolutePosition(50f, 100f);

						// Insere no PDF
						document.add(image1);

						// Insere o log da imagem
						setPara(writer.getDirectContent(), new Phrase(linhasDeLog.get(images), comentFont), 50,
								image1.getAbsoluteY() - 15);

						// Cria uma nova pagina
						if (images != prints.size() - 1) {

							document.newPage();

							// Insere a Informacao do cabecalho
							document.add(tableDescricao);
							document.add(tableNomeCenario);
						}

					} else {

						// Fixa a posicao
						image1.setAbsolutePosition(50f, 450f);

						// Insere o log da imagem
						setPara(writer.getDirectContent(), new Phrase(linhasDeLog.get(images), comentFont), 50,
								image1.getAbsoluteY() - 15);

						// Insere no PDF
						document.add(image1);

					}
				}

				// Incrementa o contador de imagens
				images++;

			}

			// close
			document.close();

		} catch (Exception e) {
			Log.error("Erro durante a montagem do PDF de evidencias: " + e);
		}

	}

	/*
	 * Função: listFilesForFolder() Responsável por listar todos os arquivos de
	 * extensão .png dentro de uma pasta recebida por parametro e retornar um
	 * arraylist dos valores.
	 * 
	 */
	public static List<String> listarArquivosDeDiretorio(final File folder) {
		ArrayList<String> prints = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.getName().substring(fileEntry.getName().length() - 4, fileEntry.getName().length())
					.equals(".png")) {
				prints.add(fileEntry.getAbsolutePath());
			}
		}
		return prints;
	}

	/*
	 * Função: leituraArquivoTexto Responsável pela leitura de qualquer tipo de
	 * arquivo
	 *
	 * Essa função tem como principio ler o arquivo inteiro seja de log ou retorno
	 * de alguma chamada onde se lê linha por linha retornando a quantidade exata de
	 * linhas do arquivo
	 *
	 */
	public static List<String> leituraArquivoTexto(String arquivo) {

		// Cria o arraylist que sera utilizado para salvar as linhas do arquivo
		List<String> linhas = new ArrayList<>();

		// Gera o arquivo de acordo com o caminho recebido por parametro
		File file = new File(arquivo);

		// Abre o arquivo em modo leitura com o ISO-8859-1
		try (BufferedReader bufRdr = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1))) {

			String st;

			// Realiza a leitura completa do arquivo, linha por linha
			while ((st = bufRdr.readLine()) != null) {

				// Salva a linha no arraylist final
				linhas.add(st);

			}

		} catch (IOException e) {
			Log.error("Nao foi possivel realizar a leitura do arquivo: " + e.toString());
		}
		return linhas;
	}

	/*
	 * Função: wait(int milisegundos) Realiza uma espera em milisegundos.
	 * 
	 * Parametros:
	 * 
	 * int milisegundos -> Receberá um valor inteiro que será utilizado como
	 * milisegundos
	 * 
	 */
	public static void wait(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			Log.warn("ThreadSleep interrompido: " + e);

			// Restaurar o estado inicial
			Thread.currentThread().interrupt();
		}
	}

	/*
	 * Função: focusElemento
	 * 
	 * Realiza o foco no elemento recebido por parametro juntamente com o ajuste de
	 * range
	 * 
	 * Parametros:
	 * 
	 * WebElement element -> Elemento que sera usado. int range -> Range alterdo.
	 * 
	 */
	public static void focusElemento(WebElement element, int range) {

		// Realiza o foco com alteracao do range
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		wait(250);
		js.executeScript("window.scrollBy(0," + range + ")", element);
		wait(250);

	}
	
	/*
	 * Função: gerarNumeroRandomicoComNDigitos
	 * 
	 * Realiza a criação de um numero randomico com uma quantidade N de digitos.
	 * 
	 * Parametros:
	 * 
	 * Int Digitos -> Inteiro que representa a quantidade de digitos que o numero
	 * randomico terá.
	 * 
	 */
	public static String gerarNumeroRandomicoComNDigitos(int digitos) {

		// SecureRandom eh preferencial ao Random simples 
		StringBuilder numero = new StringBuilder();
		for (int i = 0; i < digitos; i++) {
			numero.append(Integer.toString(new SecureRandom().nextInt(10)));
		}
		
		return numero.toString();
	}
	
	/*
	 * Função: abrirDiretorioDeEvidencias()
	 * 
	 * Responsavel por abrir no explorer.exe o diretorio de evidencias da regressao executada.
	 * 
	 */
	public static void abrirDiretorioDeEvidencias() {

		if (Boolean.parseBoolean(Gerais.capturarChaveProperties("abrirEvidencias"))) {

			try {
				// Starta o processo de captura do IP    // Validar por SO
				new ProcessBuilder().command("cmd.exe", "/c", "start " + Valores.getDirEvidencias()).start();
			} catch (Exception e) {
				Log.info("Nao foi possivel abrir automaticamente o caminho: " + Valores.getDirEvidencias());
			}
		}

	}
}
