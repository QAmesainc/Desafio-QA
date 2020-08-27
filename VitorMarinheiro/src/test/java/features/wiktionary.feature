#language:pt
#Author: vitor.marinheiro
#Data de Criação: 26/08/2020
#Data de Refatoração:

@Desafio
Funcionalidade: Desejo automatizar os testes web do desafio do MESA

  @CY0001 @apple
  Cenário: Validar apresentacao da descricao apple
    Dado que foi acessado o site 'https://en.wiktionary.org/'
    Quando for realizada uma busca no campo Look up pela palavra 'apple'
    Entao uma das definicoes contem o conteudo 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'

  @CY0002 @pear
  Cenário: Validar apresentacao da descricao pear
    Dado que foi acessado o site 'https://en.wiktionary.org/'
    Quando for realizada uma busca no campo Look up pela palavra 'pear'
    Entao uma das definicoes contem o conteudo 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'

    # Cenários poderiam ser resumidos em apenas um, já que ambos utilizam os mesmos steps.
    # Porém para melhor visualização das evidencias criadas, foi preferivel deixar os dois.