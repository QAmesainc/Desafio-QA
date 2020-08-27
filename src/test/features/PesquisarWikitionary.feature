# language: pt
#Author: Suellen Carvalho

  @TesteWiktionary
Funcionalidade: Realizar pesquisa por termos

  Cenario:  Realizar pesquisa por apple
    Dado que eu esteja na página do Wiktionary
    E pesquiso por 'apple'
    E valido frase apple
    Entao fecho o navegador

  Cenario: Realizar pesquisa por pear
    Dado que eu esteja na página do Wiktionary
    E pesquiso por 'pear'
    E valido frase pear
    Entao fecho o navegador




