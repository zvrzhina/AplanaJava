package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ApplePage extends BasePage {
    static String name;
    static String price;

    @FindBy(xpath = ".//input[@class='eFromToInput_InputField mFrom']")
    WebElement priceInput;

    @FindBy(xpath = ".//div[@id='price_filter']/descendant::div[@class='bFlatButton mMicro mWhite']")
    WebElement acceptButton;

    @FindBy(xpath = ".//div[@id='bTilesModeShow']/descendant::a[@itemprop='url']")
    WebElement modelRow;

    @FindBy(xpath = ".//div[@class='bDetailPanel']/h1")
    WebElement pathToName;

    @FindBy(xpath = ".//div[@class='bOzonPrice']")
    WebElement pathToPrice;

    @FindBy(xpath = ".//div[@class='eSaleBlock_buttons']")
    WebElement basketButton;



    public ApplePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectLeftBorder(String border){
        priceInput.click();
        priceInput.clear();
        priceInput.sendKeys(border);
        priceInput.sendKeys(Keys.TAB);
        acceptButton.click();
    }

    public void selectFirstModel(){
        modelRow.click();
        name = pathToName.getText();
        price = getFullPrice(pathToPrice);
    }

    public void goToBasket(){
        basketButton.click();
        basketButton.findElement(By.xpath(".//span[contains(text(),'Перейти')]")).click();
    }


}
