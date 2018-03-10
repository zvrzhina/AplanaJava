package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FilterResultPage extends BasePage {

    @FindBy(xpath = ".//div[@data-id]//div[contains(@class,'title')]//a")
    private List<WebElement> elementsNumberCells;

    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement searchField;

    @FindBy(xpath = ".//span[@class='search2__button']")
    public WebElement searchButton;

    static String firstResultName;

    public void checkElementsNumber(int expectedNumber){
        int productNumber = elementsNumberCells.size();
        Assert.assertEquals("Количество отображаемых товаров не равно ожидаемому количеству", expectedNumber, productNumber);
    }

    public void searchingModel(){
        //11. Запомнить первый элемент в списке.
        firstResultName = elementsNumberCells.get(0).getText();
        searchField.click();
        searchField.clear();
        searchField.sendKeys(firstResultName);
        searchButton.click();
    }

}
