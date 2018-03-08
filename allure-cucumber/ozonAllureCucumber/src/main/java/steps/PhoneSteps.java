package steps;

import pages.PhonePage;
import ru.yandex.qatools.allure.annotations.Step;

public class PhoneSteps {
    @Step("выбран производитель {0}")
    public void selectMenuItem(String itemName){
        new PhonePage().selectMenuItem(itemName);
    }
}
