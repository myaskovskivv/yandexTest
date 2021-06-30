package steps;

import pages.TvPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

public class TvSteps {
    @Step("заполнить поля {0} заявки значением {1} ")
    public void stepFillField(String field, String value) {
        new TvPage().fillField(field, value);
    }
}
