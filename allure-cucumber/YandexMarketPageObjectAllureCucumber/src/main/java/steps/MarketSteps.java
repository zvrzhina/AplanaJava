package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    @Step("выбрана общая категория {0}")
    public void selectMenuItem(String itemName){
        new MarketPage().selectMenuItem(itemName);
    }
}
