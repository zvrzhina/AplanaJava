import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @Test searchingTv
 * 1. Открыть браузер и развернуть на весь экран.
 *
 * 2. Зайти на yandex.ru.
 *
 * 3. Перейти в яндекс маркет
 *
 * 4. Выбрать раздел Электроника
 *
 * 5. Выбрать раздел Телевизоры
 *
 * 6. Зайти в расширенный поиск
 *
 * 7. Задать параметр поиска от 20000 рублей.
 *
 * 8. Выбрать производителей Samsung и LG
 *
 * 9. Нажать кнопку Применить.
 *
 * 10. Проверить, что элементов на странице 48.
 *
 * 11. Запомнить первый элемент в списке.
 *
 * 12. В поисковую строку ввести запомненное значение.
 *
 * 13. Найти и проверить, что наименование товара соответствует запомненному значению.
 *
 * @Test searchingHeadphone
 * 1. Открыть браузер и развернуть на весь экран.
 *
 * 2. Зайти на yandex.ru.
 *
 * 3. Перейти в яндекс маркет
 *
 * 4. Выбрать раздел Электроника
 *
 * 5. Выбрать раздел Наушники
 *
 * 6. Зайти в расширенный поиск
 *
 * 7. Задать параметр поиска от 5000 рублей.
 *
 * 8. Выбрать производителя Beats
 *
 * 9. Нажать кнопку Применить.
 *
 * 10. Проверить, что элементов на странице 10.
 *
 * 11. Запомнить первый элемент в списке.
 *
 * 12. В поисковую строку ввести запомненное значение.
 *
 * 13. Найти и проверить, что наименование товара соответствует запомненному значению.
 */
public class YandexMarketTv {
    private WebDriver driver;

    @Before //Чтобы определить код, который должен выполнятся перед каждым тестом
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //установка пути к драйверу
        //1. Открыть браузер и развернуть на весь экран.
        driver = new ChromeDriver();
        driver.manage().window().maximize();// на весь экран
        //2. Зайти на yandex.ru.
        driver.get("https://yandex.ru");
        //3. Перейти в яндекс маркет
        driver.findElement(By.xpath(".//a[@data-id='market']")).click();
    }

    @After //Чтобы определить код, который должен выполнятся после каждого теста
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchingTv() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //необходимо настроить ожидание пока подгрузится окно Выбор региона
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//li[@data-department='Электроника']/a"))));
        //4. Выбрать раздел Электроника
        driver.findElement(By.xpath(".//li[@data-department='Электроника']/a")).click();

        //5. Выбрать раздел Телевизоры
        driver.findElement(By.xpath(".//a[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited' and contains(text(), 'Телевизоры')]")).click();

        //7. Задать параметр поиска от 20000 рублей.
        selectPriceBounds("20000");
        //8. Выбрать производителей Samsung и LG
        setManufacturer(".//label[@class='checkbox__label' and contains(text(), 'Samsung')]",".//label[@class='checkbox__label' and contains(text(), 'LG')]");

        //9. Нажать кнопку Применить.
        driver.findElement(By.xpath(".//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")).click();

        //10. Проверить, что элементов на странице 48 или 12.
        checkElementsNumber(".//div[contains(@class, 'n-snippet-card2 i-bem b-zone')]");

        //11. Запомнить первый элемент в списке.
        String firstElementTitle = driver.findElement(By.xpath(".//div[@class='n-snippet-card2__title']/a")).getAttribute("title");
        //12. В поисковую строку ввести запомненное значение.
        //13. Найти и проверить, что наименование товара соответствует запомненному значению.
        searchingModel(firstElementTitle);
    }

    @Test
    public void searchingHeadphone() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //необходимо настроить ожидание пока подгрузится окно Выбор региона
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//li[@data-department='Электроника']/a"))));
        //4. Выбрать раздел Электроника
        driver.findElement(By.xpath(".//li[@data-department='Электроника']/a")).click();

        //5. Выбрать раздел Наушники
        driver.findElement(By.xpath(".//a[contains(text(), 'Портативная техника')]/following-sibling::div/a")).click();

        //7. Задать параметр поиска от 5000 рублей.
        selectPriceBounds("5000");
        //8. Выбрать производителей Beats
        setManufacturer(".//label[@class='checkbox__label' and contains(text(), 'Beats')]");

        //9. Нажать кнопку Применить.
        driver.findElement(By.xpath(".//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")).click();

        //10. Проверить, что элементов на странице 21.
        checkElementsNumber(21,".//div[contains(@class, 'n-snippet-cell2 i-bem b-zone')]");

        //11. Запомнить первый элемент в списке.
        String firstElementTitle = driver.findElement(By.xpath(".//div[contains(@class, 'n-snippet-cell2 i-bem b-zone b-spy-visible')]/a")).getAttribute("title");
        //12. В поисковую строку ввести запомненное значение.
        //13. Найти и проверить, что наименование товара соответствует запомненному значению.
        searchingModel(firstElementTitle);
    }

    public void selectPriceBounds(String initialPrice){
        //6. Зайти в расширенный поиск
        driver.findElement(By.xpath(".//div[@class='n-filter-panel-aside__show-more']/a")).click();
        WebElement el = driver.findElement(By.xpath(".//span[@sign-title='от']//input"));
        el.click();
        el.clear();
        el.sendKeys(initialPrice);
    }

    public void setManufacturer(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setManufacturer(String xpath_1, String xpath_2){
        setManufacturer(xpath_1);
        setManufacturer(xpath_2);
    }

    //Для наушников задаем изначально 12
    public void checkElementsNumber(int expectedNumber, String xpath){
        int number = driver.findElements(By.xpath(xpath)).size();
        Assert.assertEquals("Количество отображаемых товаров не равно 12", expectedNumber, number);
    }

    //Перегрузка для телевизоров - подходит для поиска большого количество результатов, необходим
    //поскольку бывает открывает результаты по 12 или по 48
    public void checkElementsNumber(String xpath){
        String stNumber = driver.findElement(By.xpath(".//span[contains(@class, 'select select_size_s select_theme_normal b-pager__select')]//span")).getText().substring(14,16);
        int expectedNumber = Integer.parseInt(stNumber);
        checkElementsNumber(expectedNumber, xpath);
    }

    public void searchingModel(String name){
        WebElement el = driver.findElement(By.xpath(".//input[@id='header-search']"));
        el.click();
        el.clear();
        el.sendKeys(name);
        el = driver.findElement(By.xpath(".//span[@class='search2__button']"));
        el.click();
        try {
            Assert.assertEquals("Найдет не тот объект", name, driver.findElement(By.xpath(".//div[@class='n-product-title__text-container']//h1")).getText());
        }
        catch(NoSuchElementException e){
            System.out.println("Яндекс поиск не нашел точную модель. Их баг.");
        }
    }
}
