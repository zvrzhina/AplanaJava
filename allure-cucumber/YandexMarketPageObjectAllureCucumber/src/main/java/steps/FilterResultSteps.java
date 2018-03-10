package steps;

import pages.FilterResultPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterResultSteps {

    @Step("количество элементов на странице равно {0}")
    public void checkElementsNumber(int expectedNumber){
        FilterResultPage filter = new FilterResultPage();
        filter.checkElementsNumber(expectedNumber);
    }

    @Step("запомнен первый элемент списка")
    public void searchingModel(){
        new FilterResultPage().searchingModel();
    }

}
