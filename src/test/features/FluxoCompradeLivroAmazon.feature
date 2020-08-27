# language: pt
#Author: Suellen Carvalho

Funcionalidade: Realizar teste fluxo de compra

  Cenario:  Adicionar livro ao carrinho e finalizar compra
    Dado que eu esteja na página da Amazon
    Quando realizo pesquisa por 'teste de software'
    E clico no primeiro item da lista
    E clico no botão Adicionar Carrinho
    E clico no botão fechar pedido
    E realizo meu login no site
    E escolho o endereço de envio
    E clico no botão continuar
    E seleciono a forma de pagamento 'boleto'
    E clico no botão continuar pagamento
    E clico no botão confirmar pedido
    Entao valido mensagem de feedback da compra com sucesso
    E fecho o navegador

  Cenario:  Adicionar livro ao carrinho e desistir da compra
    Dado que eu esteja na página da Amazon
    Quando realizo pesquisa por 'teste de software'
    E clico no primeiro item da lista
    E clico no botão Adicionar Carrinho
    E clico no botão no botão do carrinho
    E clico no link Excluir
    Entao valido mensagem de carrinho vazio
    E fecho o navegador
