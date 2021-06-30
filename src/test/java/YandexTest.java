
import org.junit.Ignore;
import org.junit.Test;
import pages.ElectricPage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.ElectricSteps;
import steps.MainSteps;


public class YandexTest extends BaseSteps {



    @Test
    @Title("ЯндексМаркет телевизоры")
    @Ignore
    public void testAutotest () {

        MainSteps mainSteps = new MainSteps();
        ElectricSteps electricSteps = new ElectricSteps();
        mainSteps.stepSelectMainMenu("Электроника");
        electricSteps.stepSelectElectricMenu();

        // MainPage mainPage = new MainPage();
        //mainPage.selectMenuMine("Электроника");
       // new ElectricPage().tv.click();

        //driver.findElement(By.xpath("//SPAN[@class='_3z8GfB4w3a'][text()='Электроника']")).click();
        //driver.findElement(By.xpath("//A[@href='/catalog--televizory/18040671/list?hid=90639'][text()='Телевизоры']")).click();

    }

}
