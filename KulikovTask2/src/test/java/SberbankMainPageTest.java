import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 1. Перейти на страницу http://www.sberbank.ru/ru/person
 * 2. Нажать на кнопку выбора региона
 * 3. В появившемся «окне»  при помощи поиска найти и выбрать Нижегородская область
 * 4. Проверить, что на главной странице отображается выбранная область
 * 5. Сделать скролл до footer объекта на главной странице.
 * 6. Проверить, что footer содержит значки социальных сетей
 */

public class SberbankMainPageTest {
    private WebDriver driver;

    @Before //Чтобы определить код, который должен выполнятся перед каждым тестом
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //установка пути к драйверу
        driver = new ChromeDriver();
        driver.manage().window().maximize();// на весь экран
        driver.get("http://www.sberbank.ru/ru/person"); //1. Перейти по ссылке http://www.sberbank.ru/ru/person
    }

    @After //Чтобы определить код, который должен выполнятся после каждого теста
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void regionAndFooterTest() {
        driver.findElement(By.xpath(".//span[@class='region-list__arrow']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); //необходимо настроить ожидание пока подгрузится окно Выбор региона
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//h4[@class='region-list__modal-caption']"))));
        selectRegion("Нижегородская область");

        //5. Сделать скролл до footer объекта на главной странице.
        WebElement webElem = driver.findElement(By.xpath(".//div[@class='sbrf-div-list-inner --area bp-area footer-container']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", webElem);

        //6. Проверить, что footer содержит значки социальных сетей
        checkSocialNetwork(".//a[@href='https://www.facebook.com/bankdruzey']", "https://www.facebook.com/bankdruzey");
        checkSocialNetwork(".//a[@href='http://twitter.com/sberbank/']", "http://twitter.com/sberbank/");
        checkSocialNetwork(".//a[@href='http://www.youtube.com/sberbank']", "http://www.youtube.com/sberbank");
        checkSocialNetwork(".//a[@href='http://instagram.com/sberbank']", "http://instagram.com/sberbank");
        checkSocialNetwork(".//a[@href='http://vk.com/sberbank']", "http://vk.com/sberbank");
        checkSocialNetwork(".//a[@href='https://ok.ru/sberbank']", "https://ok.ru/sberbank");
    }

    public void selectRegion (String region){
        //2. Нажать на кнопку выбора региона
        WebElement el = driver.findElement(By.xpath(".//div[@class='kit-autocomplete-input region-search-box__input']//following-sibling::input"));
        el.click();
        el.clear();
        //3. В появившемся «окне»  при помощи поиска найти и выбрать Нижегородская область
        el.sendKeys(region);
        el = driver.findElement(By.xpath(".//span[@class='region-search-box__option']/u"));
        el.click();
        //4. Проверить, что на главной странице отображается выбранная область
        Assert.assertEquals("Неверно отображается выбранный регион", region, driver.findElement(By.xpath(".//span[@class='region-list__name']")).getText());
    }

    public void checkSocialNetwork(String xpath, String link){
        WebElement el = driver.findElement(By.xpath(xpath));
        Assert.assertEquals("Социальная сеть " + link + " не найдена", link, el.getAttribute("href"));
    }
}
