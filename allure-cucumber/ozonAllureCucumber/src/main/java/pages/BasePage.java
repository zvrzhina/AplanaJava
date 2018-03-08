package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


import java.util.concurrent.TimeUnit;

public class BasePage {

    @FindBy(xpath = ".//div[@class='bDYbanner_subscription']")
    WebElement banner;

    WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public String getFullPrice(WebElement element){
        String price = element.findElement(By.xpath(".//span[contains(@class, 'eOzonPrice_main')]")).getText();
        return price;
    }

    public void bannerIsDisplayed() throws org.openqa.selenium.NoSuchElementException{
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            banner.findElement(By.xpath(".//div[contains(@class, 'close-icon')]")).click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Баннер не обнаружен");
        }
    }

    public void waitUntilElementIsVisible (WebElement el){
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10); //необходимо настроить ожидание пока подгрузится окно
        wait.until(ExpectedConditions.visibilityOf(el));
    }

}
