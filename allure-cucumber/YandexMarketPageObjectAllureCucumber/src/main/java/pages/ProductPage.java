package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ProductPage extends BasePage {

    @FindBy(xpath = ".//div[@class='n-filter-panel-aside__show-more']/a")
    public WebElement advancedSearchButton;

    public void selectAdvancedPage(){
        advancedSearchButton.click();
    }

}
