package steps;

import pages.HeadphonesPage;
import ru.yandex.qatools.allure.annotations.Step;

public class HeadphonesSteps {
    @Step("заполнить поля {0} заявки значением {1} ")
    public void stepFillField(String field, String value) {
        new HeadphonesPage().fillField(field, value);
    }
}
