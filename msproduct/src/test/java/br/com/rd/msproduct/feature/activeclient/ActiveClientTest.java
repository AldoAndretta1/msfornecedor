package br.com.rd.msproduct.feature.activeclient;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActiveClientTest {

    @Given("que eu sou cliente")
    public void thatIAMClient() {
        //Put here your code
    }

    @Given("que sou cliente")
    public void thatAmClient() {
        //Put here your code
    }

    @Given("ja realizei uma compra")
    public void alredyDoneOrder() {
        //Put here your code
    }

    @Given("e estou usando app ou site")
    public void andUsingAppOrSite() {
        //Put here your code
    }

    @Given("possuo um cupom de desconto")
    public void andHaveCouponDiscount() {
        //Put here your code
    }

    @Given("ja realizei uma compra e estou na bandeira raia")
    public void andAlredyOrderAndUtilizeTheRaiaCompany() {
        //Put here your code
    }

    @When("visualizo minhas ofertas")
    public void seeMyOfferrs() throws Exception {
        //Put here your code
    }

    @When("visualizo {int} oferta SD, caso exista")
    public void seeOnlyOfferSD(Integer int1) {
        //Put here your code
    }

    @When("visualizo {int} oferta Bonus, caso exista")
    public void seeOnlyOfferBonus(Integer int1) {
        //Put here your code
    }

    @When("visualizo ofertas da secao novidades")
    public void seeOnlyOfferNewness() {
        //Put here your code
    }

    @When("tento ativar uma oferta ja ativada")
    public void tryActiveOfferAlreadyActived() throws Exception {
        //Put here your code

    }

    @When("ativo uma oferta")
    public void activeAnOffer() {
        //Put here your code
    }

    @When("informo o codigo invalido")
    public void invalidCode() {
        //Put here your code
    }

    @When("busco informacoes do cupom promocional")
    public void findInformationFromPromotionalCoupon() {
        //Put here your code
    }

    @When("informo o codigo ja utilizado")
    public void informCodeAlreadyUtilized() {
        //Put here your code
    }

    @When("realizo a compra da oferta do cupom")
    public void purchaseOfferWithCoupon(){
        //Put here your code
    }

    @Then("ofertas bonus nao aparecem, caso existam")
    public void shouldNotAppearBonus() {
        //Put here your code
    }
    @Then("ofertas SD nao existam")
    public void shouldNotAppearSD() {
        //Put here your code
    }

    @Then("a ativacao nao e realizada")
    public void isNotCommited() throws Exception{
        //Put here your code
    }

    @Then("eh feita a ativacao da oferta")
    public void isOfferActived() throws Exception{
        //Put here your code
    }

    @Then("visualizo as ofertas nao bloqueadas relacionadas ao cupom")
    public void seeOffersAvailableThatWasNotBlockedRelatedWithCoupon() {
        //Put here your code
    }
    @Then("recebo uma mensagem de cupom de desconto nao encontrado")
    public void receiveMessageCouponWasNotFounded() {
        //Put here your code
    }

    @Then("recebo uma mensagem de cupom de desconto ja utilizado")
    public void receiveMessageCouponAlreadyUtilized() {
        //Put here your code
    }

    @Then("atualizo a data de oferecimento da oferta e cupom utilizado com sucesso")
    public void updateDateOfferAndCouponUtilizedWithSuccess() {
        //Put here your code
    }

    @Then("recebo todas as acoes desta secao caso existirem")
    public void willReceiveAllOffers() {
        //Put here your code
    }
    @Then("visualizo apenas as sessoes nao bloqueadas, sem limites de ofertas por secao")
    public void willReceiveOnlySectionsNotBlockedWithoutLimit() {
        //Put here your code
    }
}
