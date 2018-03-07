package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;


public class FilterResultPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'layout__col i-bem layout__col_search-results_normal')]")
    public WebElement ElementsNumberCells;

    @FindBy(xpath = ".//div[contains(@class, 'n-filter-applied-results metrika b-zone')]")
    public WebElement allResults;

    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement SearchField;

    @FindBy(xpath = ".//span[@class='search2__button']")
    public WebElement SearchButton;

    @FindBy(xpath = ".//div[@class='headline__header']/h1")
    public WebElement objectTypeField;

    static String productTypePart;
    static String firstResultName;


    public FilterResultPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkElementsNumber(int expectedNumber){
        int productNumber = ElementsNumberCells.findElements(By.xpath(".//div[contains(@class, 'n-snippet-" + productTypePart + "2 i-bem b-zone')]")).size();
        Assert.assertEquals("Количество отображаемых товаров не равно ожидаемому количеству", expectedNumber, productNumber);
    }

    public void searchingModel(){
        //11. Запомнить первый элемент в списке.
        firstResultName = allResults.findElement(By.xpath(".//div[contains(@class, 'n-snippet-" + productTypePart + "2__title')]/a")).getAttribute("title");
        SearchField.click();
        SearchField.clear();
        SearchField.sendKeys(firstResultName);
        SearchButton.click();
    }

    public void checkObjectType(){
        if(objectTypeField.getAttribute("title").equals("Телевизоры"))
            productTypePart = "card";
        else //наушники
            productTypePart = "cell";
    }

}
