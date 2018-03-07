package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {

    public void waitUntilElementIsVisible (WebElement el, int sec){
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), sec); //необходимо настроить ожидание пока подгрузится окно
        wait.until(ExpectedConditions.visibilityOf(el));
    }



}
