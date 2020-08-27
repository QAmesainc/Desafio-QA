# Desafio Técnico - MESA

<!--- Badges from SonarQube --->
[![Quality Gate Status](http://localhost:9000/api/project_badges/measure?project=DesafioMESA&metric=alert_status)](http://localhost:9000/dashboard?id=DesafioMESA)    [![Security Rating](http://localhost:9000/api/project_badges/measure?project=DesafioMESA&metric=security_rating)](http://localhost:9000/dashboard?id=DesafioMESA)   [![Maintainability Rating](http://localhost:9000/api/project_badges/measure?project=DesafioMESA&metric=sqale_rating)](http://localhost:9000/dashboard?id=DesafioMESA)   [![Bugs](http://localhost:9000/api/project_badges/measure?project=DesafioMESA&metric=bugs)](http://localhost:9000/dashboard?id=DesafioMESA)   [![Duplicated Lines (%)](http://localhost:9000/api/project_badges/measure?project=DesafioMESA&metric=duplicated_lines_density)](http://localhost:9000/dashboard?id=DesafioMESA)

Este projeto é a resolução do desafio da automação técnica proposto pela MESA.
A solução proposta está contida dentro desse projeto em conjunto com a parte de planejamento de testes.

> Obs: Caso seja do interesse da MESA, possuo um framework de minha autoria com o objetivo de reduzir o tempo de escrita dos fluxos e construção da arquitetura. O design permite que os testes sejam executados de forma tradicional ou dockerizada de forma paralela. Dei preferëncia por não utiliza-lo, pois não sei se seria válida a apresentação do mesmo nesse desafio proposto.

## Organização

Segue divisão entre as categorias de resolução propostas e seus respectivos caminhos dentro do repositório.

|Categoria         | Caminho             |
|------------------|---------------------|
|Automação         |*_VitorMarinheiro_*|
|Planejamento      |*_Planejamento_*   |


## Tecnologias
- [Java](https://www.java.com/)
- [Selenium](https://www.selenium.dev/_)
- [Cucumber](https://cucumber.io/)
- [TestNG](https://testng.org/doc/)
- [Maven](https://maven.apache.org/)
- [SonarQube](https://www.sonarqube.org/)

## Recursos
A resolução do desafio usa vários recursos existentes na estrutura atual e mantém um padrão que facilita a adição de  novos recursos no futuro:

- [x] Highlight dos elementos utilizados.
- [x] Arquivo de Evidëncias (.pdf)
- [x] Execução local em dois Browsers.
- [x] SonarQube Scanner.
- [ ] Paralelismo utilizando Docker.
- [ ] Orquestração de Nós e Hub.
- [ ] Integração com Jenkins utilizando Dockerfile.

## Pré-requisitos
Como a execução está sendo feita localmente sem o uso de containers ou RemoteWebDriver's, não existe necessidade de diversas instalações e adequações na máquina utilizada.


Tabela com pré-requisitos para execução:


|Item         | Requerido                         |
|-------------|-----------------------------------|
|Java         |:white_check_mark:|
|Maven        |:white_check_mark:|
|Chrome       |:white_check_mark:|
|Firefox      |** :x:|

> ** O Firefox só é necessário caso o usuário queira executar a automação nesse navegador.


## Configuração
A configuração para executar a solução pode ser encontrada no arquivo de propriedades localizado no caminho **_\src\main\java\properties_** dentro do projeto.

- Navegador de Execução: **chrome** ou **firefox**
- Tempo de espera para o surgimento de elemento: **Integer**
- Abrir evidëncias após execução: **true** ou **false**


## Executando os Testes
O usuário pode acessar os logs de execução de teste diretamente do console de saída de automação, o log é concatenado pela data e hora atuais e usado com divisões entre erros, informações, depurações e avisos.
```
[INFO ] - 14:49:40 - Browser: Chrome
```

## Fim da Execução
Após os testes, os arquivos serão criados dentro da pasta de execução. Cada execução (independentemente do número de testes) terá sua própria pasta nomeada contendo a data e hora de início, e dentro dela estarão as ramificações para cada teste específico.
Cada execução irá gerar um relatório simples em formato HTML onde poderão ser visualizados os fluxos executados e seu devido status.

Cada cenário trará dentro de seu diretório de execução, um arquivo .pdf contendo as informações compiladas do teste e também os screenshots ordenados cronologicamente com suas respectivas descrições.

Ainda dentro do diretório de execução do cenário, podemos encontrar outros diretórios contendo os arquivos de log do navegador ou automação e o diretório contendo todas as Capturas de Tela obtidas durante o fluxo.

## Comentários

- As entradas dos parâmetros nos cenários de teste podem ser feitas usando a entrada de uma planilha excel ou mesmo de um banco de dados local.
> Sim, mas como o número desses parâmetros é muito pequeno, não faz sentido usar esses modos. Esses parâmetros podem ser alterados diretamente no BDD do arquivo Feature.

- Etapa do pipeline contendo a criação do relatório do cucumber utilizando o plugin Jenkins, criação da documentação funcional dos fluxos executados e arquivamento dos artefatos de execução:
```
stage('Report') {
    steps {
        echo 'Arquivando artefatos de execução.'
        archiveArtifacts 'resources\\Evidencias\\**'
        echo 'Gerando a documentação funcional.'
        livingDocs featuresDir: 'target\\cucumber-reports'
        echo 'Criando o Report do Cucumber.'
        cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', hideEmptyHooks: true, jsonReportDirectory: '\\target\\cucumber-reports', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'NATURAL', undefinedStepsNumber: -1
    }
}
```

- Report do Cucumber via Jenkins.
>![](/VitorMarinheiro/src/resources/suporte/ReportGIF.gif)

- Documentação gerada automaticamente após execução via Jenkins.
>![](/VitorMarinheiro/src/resources/suporte/Documentation.png)

- Scanner do SonarQube comprovando qualidade de código estático.
>![](/VitorMarinheiro/src/resources/suporte/sonarQube.png)
