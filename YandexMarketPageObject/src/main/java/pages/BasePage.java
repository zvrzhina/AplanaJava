package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;


    public void waitUntilElementIsVisible (WebElement el, int sec){
        WebDriverWait wait = new WebDriverWait(driver, sec); //необходимо настроить ожидание пока подгрузится окно Выбор региона
        wait.until(ExpectedConditions.visibilityOf(el));
    }



}
