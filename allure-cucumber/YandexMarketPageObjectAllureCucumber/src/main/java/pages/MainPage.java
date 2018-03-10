package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {
    @FindBy(xpath = ".//div[@class='home-arrow__tabs']")
    WebElement menuItem;

    public void selectMenuItem(String itemName){
        menuItem.findElement(By.xpath(".//a[contains(text(), '" + itemName + "')]")).click();
    }
}
