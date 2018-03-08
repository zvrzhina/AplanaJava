package steps;

import pages.BasketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class BasketSteps {

    @Step("проверить наличие добавленного товара в корзине")
    public void checkNameAndPrice(){
        new BasketPage().checkNameAndPrice();
    }

    @Step("нажата кнопка удалить все")
    public void removeAll(){
        new BasketPage().removeAll();
    }

    @Step("проверить, что корзина пуста")
    public void basketIsEmpty(){
        new BasketPage().basketIsEmpty();
    }
}
