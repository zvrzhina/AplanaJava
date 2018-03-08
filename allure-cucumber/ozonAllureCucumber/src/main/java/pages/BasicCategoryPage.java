package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BasicCategoryPage extends BasePage {

    @FindBy(xpath = ".//div[@class='bHeaderCategoryLinks ']")
    WebElement menuItem;

    public BasicCategoryPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName){
        bannerIsDisplayed();
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }

}
