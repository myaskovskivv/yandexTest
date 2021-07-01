package steps;

import pages.HeadphonesPageAfterFind;
import pages.TvPageAfterFind;
import ru.yandex.qatools.allure.annotations.Step;

public class HeadphonesAfterFindSteps {

    @Step("запомнить строку")
    public void afterFind() {
        new HeadphonesPageAfterFind().findArticlId();
    }
}
