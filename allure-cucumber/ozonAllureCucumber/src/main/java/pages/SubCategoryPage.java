package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SubCategoryPage extends BasePage {

    @FindBy(xpath = ".//div[@id='TDpageLeft']")
    WebElement menuItem;

    public void selectMenuItem(String itemName){
        bannerIsDisplayed();
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }

}
