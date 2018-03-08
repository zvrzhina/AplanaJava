package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class PhonePage extends BasePage {

    @FindBy(xpath = ".//ul[contains(@class, 'eFilterList_List')]")
    WebElement menuItem;

    public PhonePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        bannerIsDisplayed();
        menuItem.findElement(By.xpath(".//*[contains(text(), '" + itemName + "')]")).click();
    }
}
