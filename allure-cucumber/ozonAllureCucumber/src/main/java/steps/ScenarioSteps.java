package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    BasicCategorySteps basicCategorySteps = new BasicCategorySteps();
    SubCategorySteps subCategorySteps = new SubCategorySteps();
    PhoneSteps phoneSteps = new PhoneSteps();
    AppleSteps appleSteps = new AppleSteps();
    BasketSteps basketSteps = new BasketSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectBasicCategory(String itemName){
        basicCategorySteps.selectMenuItem(itemName);
    }

    @When("^выбрана категория \"(.+)\"$")
    public void selectSubCategory(String itemName){
        subCategorySteps.selectMenuItem(itemName);
    }

    @When("^выбран производитель \"(.+)\"$")
    public void selectManufacturer(String itemName){
        phoneSteps.selectMenuItem(itemName);
    }

    @When("^заполнена цена от \"(.+)\"$")
    public void selectLeftBorder(String itemName){
        appleSteps.selectLeftBorder(itemName);
    }


    @When("когда добавлен первый товар в корзину и запомнены название и цена")
    public void selectFirstModel(){
        appleSteps.selectFirstModel();
    }

    @When("совершен переход в корзину")
    public void goToBasket(){
        appleSteps.goToBasket();
    }

    @Then("проверить наличие добавленного товара в корзине")
    public void checkNameAndPrice(){
        basketSteps.checkNameAndPrice();
    }

    @When("нажата кнопка удалить все")
    public void removeAll(){
        basketSteps.removeAll();
    }

    @Then("проверить, что корзина пуста")
    public void basketIsEmpty(){
        basketSteps.basketIsEmpty();
    }

}
