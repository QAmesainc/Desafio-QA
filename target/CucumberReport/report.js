$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/PesquisarWikitionary.feature");
formatter.feature({
  "name": "Realizar pesquisa por termos",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@TesteWiktionary"
    }
  ]
});
formatter.scenario({
  "name": "Realizar pesquisa por apple",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@TesteWiktionary"
    }
  ]
});
formatter.step({
  "name": "que eu esteja na página do Wiktionary",
  "keyword": "Dado "
});
formatter.match({
  "location": "Util.AbrirNavegador()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquiso por \u0027apple\u0027",
  "keyword": "E "
});
formatter.match({
  "location": "HomeStepDef.buscarPalavra(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido frase apple",
  "keyword": "E "
});
formatter.match({
  "location": "HomeStepDef.validarFrase2()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fecho o navegador",
  "keyword": "Entao "
});
formatter.match({
  "location": "Util.FecharNavegador()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Realizar pesquisa por pear",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@TesteWiktionary"
    }
  ]
});
formatter.step({
  "name": "que eu esteja na página do Wiktionary",
  "keyword": "Dado "
});
formatter.match({
  "location": "Util.AbrirNavegador()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pesquiso por \u0027pear\u0027",
  "keyword": "E "
});
formatter.match({
  "location": "HomeStepDef.buscarPalavra(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido frase pear",
  "keyword": "E "
});
formatter.match({
  "location": "HomeStepDef.validarFrase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fecho o navegador",
  "keyword": "Entao "
});
formatter.match({
  "location": "Util.FecharNavegador()"
});
formatter.result({
  "status": "passed"
});
});