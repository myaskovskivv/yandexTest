package steps;

import pages.TvPage;
import pages.TvPageAfterFind;
import ru.yandex.qatools.allure.annotations.Step;

public class TvAfterFindSteps {

    @Step("запомнить строку")
    public void afterFind() {
        new TvPageAfterFind().findArticlId();
    }

}
