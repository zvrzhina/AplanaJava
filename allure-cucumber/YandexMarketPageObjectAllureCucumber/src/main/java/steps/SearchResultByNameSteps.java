package steps;

import pages.SearchResultByNamePage;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchResultByNameSteps {

    @Step("наименование товара соответствует запомненному значению")
    public void checkTitles(){
        new SearchResultByNamePage().checkTitles();
    }
}
