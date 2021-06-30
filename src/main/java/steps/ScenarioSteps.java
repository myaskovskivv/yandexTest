package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

import java.util.ArrayList;

public class ScenarioSteps {

  MainSteps mainSteps = new MainSteps();
  ElectricSteps electricSteps = new ElectricSteps();
  TvSteps tvSteps = new TvSteps();
  TvAfterFindSteps tvAfterFindSteps = new TvAfterFindSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^нажата кнопка Телевизоры")
    public void stepSelectElectricBtn(){
        electricSteps.stepSelectElectricMenu();
    }

    @When("^заполняется Модель ТВ")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> tvSteps.stepFillField(field, value)
        );
    }

    @When("^найден телевизор")
    public void stepFindTV(){
        tvAfterFindSteps.afterFind();
    }
}
