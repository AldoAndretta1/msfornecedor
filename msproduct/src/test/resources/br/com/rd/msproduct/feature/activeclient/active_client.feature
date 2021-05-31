
Feature: Cliente ativo que realizou pelo menos uma compra nos ultimos 12 meses.
  #Ativar oferta
  @web
  Scenario: Cliente ativa uma oferta e eh feita a ativacao
    Given que eu sou cliente
    When ativo uma oferta
    Then eh feita a ativacao da oferta

  Scenario: Cliente faz tentativa de ativar uma oferta ja ativada e a ativacao nao e efetuada
    Given que eu sou cliente
    When tento ativar uma oferta ja ativada
    Then a ativacao nao e realizada

  #Buscar oferta cupom
  Scenario: Cliente usando app ou site busca informacoes do cupom promocional e visualiza as ofertas nao bloqueadas daquele cupom.
    Given que eu sou cliente
    And e estou usando app ou site
    When busco informacoes do cupom promocional
    Then visualizo as ofertas nao bloqueadas relacionadas ao cupom

  Scenario: Cliente usando app ou site deve informar codigo do cupom invalido e receber mensagem cupom de desconto nao encontrado
    Given que eu sou cliente
    And e estou usando app ou site
    When informo o codigo invalido
    Then recebo uma mensagem de cupom de desconto nao encontrado

  Scenario: Cliente usando app ou site deve informar codigo do cupom ja utilizado e receber mensagem cupom de desconto ja utilizado
    Given que eu sou cliente
    And e estou usando app ou site
    When informo o codigo ja utilizado
    Then recebo uma mensagem de cupom de desconto ja utilizado

  #Consumir oferta
  Scenario: Cliente possui cupom de desconto e ao realizar a compra da oferta do cupom deve atualizar a data de oferecimento da oferta e cupom utilizado.
    Given que eu sou cliente
    And possuo um cupom de desconto
    When realizo a compra da oferta do cupom
    Then atualizo a data de oferecimento da oferta e cupom utilizado com sucesso

  #Buscar oferta
  Scenario: Cliente visualiza apenas as sessoes nao bloqueadas, sem limites de ofertas por secao
    Given que sou cliente
    And ja realizei uma compra
    When visualizo minhas ofertas
    Then visualizo apenas as sessoes nao bloqueadas, sem limites de ofertas por secao

  Scenario: Cliente visualiza 1 oferta SD e as ofertas bonus nao aparecem
    Given que sou cliente
    And ja realizei uma compra
    When visualizo 1 oferta SD, caso exista
    Then ofertas bonus nao aparecem, caso existam

  Scenario: 'Cliente visualiza 1 oferta Bonus e ofertas SD nao existe'
    Given que sou cliente
    And ja realizei uma compra
    When visualizo 1 oferta Bonus, caso exista
    Then ofertas SD nao existam

  Scenario: Cliente Raia visualiza 1 oferta Novidade e ofertas SD nao existe
    Given que sou cliente
    And ja realizei uma compra e estou na bandeira raia
    When visualizo ofertas da secao novidades
    Then recebo todas as acoes desta secao caso existirem