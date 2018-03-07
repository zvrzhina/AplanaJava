package steps;

import pages.FiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FiltersSteps {

    @Step("задан параметр поиска от {0}")
    public void selectPriceBounds(String initialPrice){
        new FiltersPage().selectPriceBounds(initialPrice);
    }

    @Step("выбран производитель {0}")
    public void setManufacturer(String name){
        new FiltersPage().setManufacturer(name);
    }

    @Step("нажать кнопку Применить")
    public void pushAccept(){
        new FiltersPage().pushAccept();
    }

}
