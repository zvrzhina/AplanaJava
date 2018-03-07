package steps;


import pages.ProductPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductSteps {
    @Step("зайти в расширенный поиск")
    public void selectMenuItem(){
        new ProductPage().selectAdvancedPage();
    }
}
