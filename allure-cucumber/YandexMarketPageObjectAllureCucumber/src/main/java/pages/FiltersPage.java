package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class FiltersPage extends BasePage{

    @FindBy(xpath = ".//span[@sign-title='от']//input")
    public WebElement priceField;

    @FindBy(xpath = ".//div[@class='n-filter-block__header']//span[text()='Производитель']")
    public WebElement manufacturer;

    @FindBy(xpath = ".//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")
    public WebElement accept;


    public void selectPriceBounds(String initialPrice){
        priceField.click();
        priceField.clear();
        priceField.sendKeys(initialPrice);
    }

    public void setManufacturer(String name){
        manufacturer.findElement(By.xpath(".//following::label[contains(text(), '" + name + "')]")).click();
    }

    public void pushAccept(){
        accept.click();
    }
}
