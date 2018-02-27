import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Задание, выполняемое Test_1
 * 1. Перейти по ссылке http://www.rgs.ru
 * 2. Выбрать пункт меню - Страхование
 * 3. Выбрать категорию - ДМС
 * 4. Проверить наличие заголовка - Добровольное медицинское страхование
 * 5. Нажать на кнопку - Отправить заявку
 * 6. Проверить, что открылась страница , на которой присутствует текст - Заявка на добровольное медицинское страхование
 * 7.Заполнить поля
 * Имя
 * Фамилия
 * Отчество
 * Регион
 * Телефон
 * Эл. почта - qwertyqwerty
 * Комментарии
 * Я согласен на обработку
 * <p>
 * 8. Проверить, что все поля заполнены введенными значениями
 * 9. Нажать Отправить
 * 10. Проверить, что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email
 */
public class Test_1 {
    private WebDriver driver;

    @Before //Чтобы определить код, который должен выполнятся перед каждым тестом
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //установка пути к драйверу
        driver = new ChromeDriver();
        driver.manage().window().maximize();// на весь экран
        driver.get("https://www.rgs.ru/"); //1. Перейти по ссылке http://www.rgs.ru
    }

    @After //Чтобы определить код, который должен выполнятся после каждого теста
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException{
        WebElement navbar = driver.findElement(By.xpath(".//div[contains(@id, 'main-navbar')]"));
        navbar.findElement(By.xpath(".//a[contains(text(), 'Страхование')]")).click(); //2. Выбрать пункт меню - Страхование
        navbar.findElement(By.xpath(".//a[contains(text(), 'ДМС')]")).click(); //3. Выбрать категорию - ДМС
        Assert.assertEquals("Заголовок ДМС не соответствует ожидаемому", "ДМС \uD83D\uDE91 Добровольное медицинское страхование, рассчитать стоимость в Росгосстрахе", driver.getTitle()); //4. Проверить наличие заголовка - Добровольное медицинское страхование
        //Wait <WebDriver> wait = new WebDriverWait(driver, 5, 1000); //необходимо настроить ожидание пока подгрузится отправить заявку
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[contains(text(),'Отправить заявку')]"))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//a[contains(text(),'Отправить заявку')]")).click(); //5. Нажать на кнопку - Отправить заявку
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='modal-title']/b"))));
        Thread.sleep(1000);
        String exptectedTitle = driver.findElement(By.xpath(".//*[@class='modal-title']/b")).getText();
        Assert.assertEquals("У модального окна не правильный заголовок h4", "Заявка на добровольное медицинское страхование", exptectedTitle); //6. Проверить, что открылась страница , на которой присутствует текст - Заявка на добровольное медицинское страхование
        //7.Заполнить поля
        driver.findElement(By.xpath(".//label[text()='Фамилия']/following-sibling::input")).sendKeys("Хомяков");
        driver.findElement(By.xpath(".//label[text()='Имя']/following-sibling::input")).sendKeys("Иван");
        driver.findElement(By.xpath(".//label[text()='Отчество']/following-sibling::input")).sendKeys("Петрович");
        driver.findElement(By.xpath(".//label[text()='Телефон']/following-sibling::input")).sendKeys("9555555555");
        driver.findElement(By.xpath(".//label[text()='Эл. почта']/following-sibling::input")).sendKeys("qwertyqwerty");
        driver.findElement(By.xpath(".//label[text()='Предпочитаемая дата контакта']/following-sibling::input")).sendKeys("05062018");
        driver.findElement(By.xpath(".//label[text()='Комментарии']/following-sibling::textarea")).sendKeys("ййййй");
        driver.findElement(By.xpath(".//h4[contains(text(),' Контактная информация ')]")).click();
        WebElement lastName = driver.findElement(By.xpath(".//label[text()='Фамилия']/following-sibling::input"));
        WebElement firstName = driver.findElement(By.xpath(".//label[text()='Имя']/following-sibling::input"));
        WebElement fathersName = driver.findElement(By.xpath(".//label[text()='Отчество']/following-sibling::input"));
        WebElement mobile = driver.findElement(By.xpath(".//label[text()='Телефон']/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath(".//label[text()='Эл. почта']/following-sibling::input"));
        WebElement date = driver.findElement(By.xpath(".//label[text()='Предпочитаемая дата контакта']/following-sibling::input"));
        WebElement comment = driver.findElement(By.xpath(".//label[text()='Комментарии']/following-sibling::textarea"));
        WebElement element = driver.findElement(By.name("Region"));
        Select select = new Select(element);
        select.selectByVisibleText("Тверская область");
        driver.findElement(By.xpath(".//input[contains(@class, 'checkbox')]")).click();
        //Проверка выбранных значений
        select.getFirstSelectedOption();
        Assert.assertEquals("Введенное значение в поле Фамилия не совпадает", "Хомяков", lastName.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Имя не совпадает", "Иван", firstName.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Отчество не совпадает", "Петрович", fathersName.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Телефон не совпадает", "+7 (955) 555-55-55", mobile.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Эл. почта не совпадает", "qwertyqwerty", email.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Предпочитаемая дата контакта не совпадает", "05.06.2018", date.getAttribute("value"));
        Assert.assertEquals("Введенное значение в поле Комментарии не совпадает", "ййййй", comment.getAttribute("value"));
        //нажать Отправить
        driver.findElement(By.xpath(".//button[contains(@id, 'button-m')]")).click();
        //Сообщение об ошибке почты
        Assert.assertEquals("Неверный адрес почты","Введите адрес электронной почты", driver.findElement(By.xpath(".//*[@class='validation-error-text']")).getText());
    }

}

