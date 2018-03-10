package steps;

import pages.ElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronicsSteps {

    @Step("выбран раздел {0}")
    public void selectMenuItem(String itemName){
        new ElectronicsPage().chooseCategory(itemName);
    }
}
