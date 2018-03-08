package steps;

import pages.SubCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SubCategorySteps {

    @Step("выбрана категория {0}")
    public void selectMenuItem(String itemName){
        new SubCategoryPage().selectMenuItem(itemName);
    }

}
