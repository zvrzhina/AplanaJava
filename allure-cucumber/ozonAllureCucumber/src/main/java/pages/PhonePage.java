package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PhonePage extends BasePage {

    @FindBy(xpath = ".//ul[contains(@class, 'eFilterList_List')]")
    WebElement menuItem;

    public void selectMenuItem(String itemName){
        bannerIsDisplayed();
        menuItem.findElement(By.xpath(".//*[contains(text(), '" + itemName + "')]")).click();
    }
}
