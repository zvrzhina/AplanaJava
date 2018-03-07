package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketPage extends BasePage {
    @FindBy(xpath = ".//ul[contains(@class, 'topmenu__list')] | .//div[@class='n-navigation-horizontal__inner']")
    WebElement menuItem;



    public MarketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }
}
