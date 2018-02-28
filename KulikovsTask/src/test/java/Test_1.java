import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    public static final String xpathPhone = ".//label[text()='Телефон']/following-sibling::input";
    public static final String xpathDate = ".//label[text()='Предпочитаемая дата контакта']/following-sibling::input";

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
    public void test1() throws InterruptedException {
        WebElement navbar = driver.findElement(By.xpath(".//div[contains(@id, 'main-navbar')]"));
        navbar.findElement(By.xpath(".//a[contains(text(), 'Страхование')]")).click(); //2. Выбрать пункт меню - Страхование
        navbar.findElement(By.xpath(".//a[contains(text(), 'ДМС')]")).click(); //3. Выбрать категорию - ДМС

        Assert.assertEquals("Заголовок ДМС не соответствует ожидаемому", "ДМС \uD83D\uDE91 Добровольное медицинское страхование, рассчитать стоимость в Росгосстрахе", driver.getTitle()); //4. Проверить наличие заголовка - Добровольное медицинское страхование

        WebDriverWait wait = new WebDriverWait(driver, 20); //необходимо настроить ожидание пока подгрузится отправить заявку
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[contains(text(),'Отправить заявку')]"))));
        driver.findElement(By.xpath(".//a[contains(text(),'Отправить заявку')]")).click(); //5. Нажать на кнопку - Отправить заявку


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='modal-title']/b"))));
        String actualTitle = driver.findElement(By.xpath(".//*[@class='modal-title']/b")).getText();
        Assert.assertEquals("У модального окна неправильный заголовок h4", "Заявка на добровольное медицинское страхование", actualTitle); //6. Проверить, что открылась страница , на которой присутствует текст - Заявка на добровольное медицинское страхование

        //7.Заполнить и проверить поля
        fillField(".//label[text()='Фамилия']/following-sibling::input", "Хомяков");
        fillField(".//label[text()='Имя']/following-sibling::input", "Иван");
        fillField(".//label[text()='Отчество']/following-sibling::input", "Петрович");

        WebElement element = driver.findElement(By.name("Region"));
        Select select = new Select(element);
        select.selectByVisibleText("Тверская область");
        driver.findElement(By.xpath(".//input[contains(@class, 'checkbox')]")).click();
        Assert.assertEquals("Поле регион не совпадает", "Тверская область", select.getFirstSelectedOption().getText() );

        fillField(".//label[text()='Телефон']/following-sibling::input", "9555555555");
        fillField(".//label[text()='Эл. почта']/following-sibling::input", "qwertyqwerty");
        fillField(".//label[text()='Предпочитаемая дата контакта']/following-sibling::input", "05062018");
        fillField(".//label[text()='Комментарии']/following-sibling::textarea", "ййййй");

        driver.findElement(By.xpath(".//h4[contains(text(),' Контактная информация ')]")).click();

        //9. Нажать Отправить
        driver.findElement(By.xpath(".//button[contains(@id, 'button-m') and contains(text(), 'Отправить')]")).click();
        //10. Проверить, что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email
        Assert.assertEquals("Неверный адрес почты", "Введите адрес электронной почты", driver.findElement(By.xpath(".//span[@class = 'validation-error-text' and contains(text(), 'Введите адрес электронной почты')]")).getText());
    }

    /**
     * Функция заполняет поля и проверяет введенные значения
     * @param xpath - xpath поля
     * @param value - значение вводимое в поле
     */
    public void fillField(String xpath, String value) {
        WebElement el = driver.findElement(By.xpath(xpath));
        el.click();
        el.clear(); // очистить если в поле что-то набрано
        el.sendKeys(value);
        el.sendKeys(Keys.TAB); // переход на следующее поле
        if (xpath == xpathPhone)
            value = templatePhoneNumber(value);
        if (xpath == xpathDate)
            value = templateDate(value);
        Assert.assertEquals("Поле xpath: " + xpath +  " заполнено не верно.", value, el.getAttribute("value"));
    }

    /**
     *
     * @param initialNumber - номер, которому требуется преобразовать вид
     * @return возвращает отформатированный по шаблону номер
     */
    public String templatePhoneNumber (String initialNumber) {
        String st = "+7 (";
        st = st + initialNumber.substring(0,3) + ") " +
                initialNumber.substring(3,6) + "-" +
                initialNumber.substring(6,8) + "-" + initialNumber.substring(8,10);
        return st;
    }

    /**
     *
     * @param initialDate - дата до приведения к стандартному виду
     * @return возвращает отформатированную по шаблону дату
     */
    public String templateDate (String initialDate) {
        String st = initialDate.substring(0,2) + "." +
                initialDate.substring(2,4) + "." + initialDate.substring(4,8);
        return st;
    }
}

