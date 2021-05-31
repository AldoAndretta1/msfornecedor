Feature: CRUD simples product

    #Criar produto
    Scenario: Criacao de produto
        Given tenho um produto
        When crio um produto
        Then produto criado

    #Buscar um produto
    Scenario: Buscar o produto por id
        Given tenho id do produto
        When busco um produto
        Then retorna um produto

    Scenario: Buscar o produto por id e nao encontrar
        Given eu tenho o id de um produto
        When busco um produto inexistente
        Then produto nao encontrado

    Scenario: Buscar todos produtos por paginacao
        Given passo uma paginacao
        When busco todos os produtos
        Then retorna todos produtos paginados

    #Atualizar produto
    Scenario: Atualizar um produto existente
        Given tenho um produto
        When atualizo um produto
        Then produto atualizado

    #Excluir Produto
    Scenario: Excluir um produto existente
        Given tenho id do produto
        When excluo um produto por id
        Then produto excluido

    Scenario: Excluir um produto inexistente
        Given tenho id do produto inexistente
        When excluo um produto
        Then produto nao excluido
