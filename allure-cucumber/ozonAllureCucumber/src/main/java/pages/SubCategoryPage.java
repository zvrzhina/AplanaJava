package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class SubCategoryPage extends BasePage {

    @FindBy(xpath = ".//div[@id='TDpageLeft']")
    WebElement menuItem;

    public SubCategoryPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        bannerIsDisplayed();
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }

}
