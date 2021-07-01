package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class ScenarioSteps {

  MainSteps mainSteps = new MainSteps();
  ElectricSteps electricSteps = new ElectricSteps();
  TvSteps tvSteps = new TvSteps();
  HeadphonesSteps headphonesSteps = new HeadphonesSteps();
  TvAfterFindSteps tvAfterFindSteps = new TvAfterFindSteps();
  HeadphonesAfterFindSteps headphonesAfterFindSteps = new HeadphonesAfterFindSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^нажата кнопка Телевизоры")
    public void stepSelectElectricBtn(){
        electricSteps.stepSelectElectricMenu();
    }

    @When("^заполняется Модель ТВ")
    public void stepFillFieldsTV(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> tvSteps.stepFillField(field, value)
        );
    }

    @When("^найден телевизор")
    public void stepFindTV(){
        tvAfterFindSteps.afterFind();
    }

    @When("^нажата кнопка наушники")
    public void stepFindHeadPhone(){
        electricSteps.stepSelectElectricHeadPhoneMenu();
    }

    @When("^заполняется Модель Наушников")
    public void stepFillFieldsHeads(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (field, value) -> headphonesSteps.stepFillField(field, value)
        );
    }
    @When("^найдеы наушники")
    public void stepFindHeads(){
        headphonesAfterFindSteps.afterFind();
    }
}
