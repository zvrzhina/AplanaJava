package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasketPage extends BasePage {

    @FindBy(xpath = ".//span[@class='eCartItem_nameValue']")
    WebElement itemName;

    @FindBy(xpath = ".//div[@class='eTotalPrices_total ']")
    WebElement itemPrice;

    @FindBy(xpath = ".//div[@class='eCartControls_buttons']")
    WebElement removeButton;


    @FindBy(xpath = ".//span[contains(text(), '\t\t\t\tКорзина')]")
    WebElement emptyBasket;

    public BasketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkNameAndPrice(){
        Assert.assertEquals("Наименование телефона в корзине не верно.", ApplePage.name, itemName.getText());
        Assert.assertEquals("Цена телефона в корзине не верна.", ApplePage.price, getFullPrice(itemPrice));
    }

    public void removeAll(){
        removeButton.click();
    }

    public void basketIsEmpty(){
        Assert.assertTrue("корзина не пуста", emptyBasket.isDisplayed());
    }




}
