package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


import java.util.concurrent.TimeUnit;

public class BasePage {

    @FindBy(xpath = ".//div[@class='bDYbanner_subscription']//div[contains(@class, 'close-icon')]")
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
            banner.click();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Баннер не обнаружен");
        }
    }

}
