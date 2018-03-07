package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ElectronicsPage extends BasePage {
    @FindBy(xpath = ".//div[contains(@class, 'layout-grid__col layout-grid__col_width_2')]")
    WebElement menuItem;

    public ElectronicsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void chooseCategory(String product){
        menuItem.findElement(By.xpath(".//div[@class='catalog-menu__list']/a[contains(text(), '" + product + "')]")).click();
    }


}
