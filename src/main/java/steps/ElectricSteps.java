package steps;

import pages.ElectricPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectricSteps {

    @Step ("выбран пункт меню {0}")
    public void stepSelectElectricMenu(){
        new ElectricPage().tv.click();
    }

    @Step ("выбран пункт меню {0}")
    public void stepSelectElectricHeadPhoneMenu(){
        new ElectricPage().headphones.click();
    }
}
