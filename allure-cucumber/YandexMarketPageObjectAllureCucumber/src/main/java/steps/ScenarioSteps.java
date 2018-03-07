package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    MarketSteps marketSteps = new MarketSteps();
    ElectronicsSteps  electronicsSteps = new ElectronicsSteps();
    ProductSteps productSteps = new ProductSteps();
    FiltersSteps filtersSteps = new FiltersSteps();
    FilterResultSteps filterResultSteps = new FilterResultSteps();
    SearchResultByNameSteps searchResultByNameSteps = new SearchResultByNameSteps();



    @When("^выбран пункт меню \"(.+)\"$")
        public void selectMenuItem(String itemName){
        mainPageSteps.selectMenuItem(itemName);
    }

    @When("^выбран раздел общих категорий \"(.+)\"$")
    public void selectSection(String itemName){
        marketSteps.selectMenuItem(itemName);
    }

    @When("^выбран раздел \"(.+)\"$")
    public void selectProductGroup(String itemName){
        electronicsSteps.selectMenuItem(itemName);
    }

    @Then("зайти в расширенный поиск")
    public void goToAdvancedSearch(){
        productSteps.selectMenuItem();
    }

    @When("^задан параметр поиска от \"(.+)\"$")
    public void selectPriceBounds(String initialPrice){
        filtersSteps.selectPriceBounds(initialPrice);
    }

    @When("^выбран производитель \"(.+)\"$")
    public void setManufacturer(String name){
        filtersSteps.setManufacturer(name);
    }

    @Then("нажать кнопку Применить")
    public void pushAccept(){
        filtersSteps.pushAccept();
    }

    @Given("количество элементов на странице равно \"(.+)\"$")
    public void checkElementsNumber(int expectedNumber){
        filterResultSteps.checkElementsNumber(expectedNumber);
    }

    @When("запомнен первый элемент списка")
    public void searchingModel(){
        filterResultSteps.searchingModel();
    }

    @Then("наименование товара соответствует запомненному значению")
    public void checkTitles(){
        searchResultByNameSteps.checkTitles();
    }








}
