package steps;

import pages.ApplePage;
import ru.yandex.qatools.allure.annotations.Step;

public class AppleSteps {
    @Step("заполнена цена от {0}")
    public void selectLeftBorder(String itemName) {
        new ApplePage().selectLeftBorder(itemName);
    }

    @Step("когда добавлен первый товар в корзину и запомнены название и цена")
    public void selectFirstModel() {
        new ApplePage().selectFirstModel();
    }

    @Step("совершен переход в корзину")
    public void goToBasket() {
        new ApplePage().goToBasket();
    }

}

