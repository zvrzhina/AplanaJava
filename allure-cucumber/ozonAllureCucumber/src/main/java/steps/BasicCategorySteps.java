package steps;

import pages.BasicCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class BasicCategorySteps {
    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String itemName){
        new BasicCategoryPage().selectMenuItem(itemName);
    }
}
