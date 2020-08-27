# language: pt
#Author: Suellen Carvalho

Funcionalidade: Realizar teste fluxo de devoluções e Pedidos

  Cenario:  verificar dados do pedido
    Dado que eu esteja na página da Amazon
    Quando clico no link de devolucoes e pedidos
    E realizei o login
    E clico no link de dados do pedido
    Entao valido que o titulo do livro é o mesmo nas duas páginas
    E fecho o navegador

  Cenario:  Realizar avaliação do pedido sem preencher campos
    Dado que eu esteja na página da Amazon
    Quando clico no link de devolucoes e pedidos
    E realizei o login
    E clico no botao Avaliar o Produto
    E clico no botão enviar
    Entao valido mensagem de erro nos campos obrigatórios
    E fecho o navegador
