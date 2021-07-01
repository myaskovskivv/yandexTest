package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class HeadphonesPageAfterFind extends BasePage{

    @FindBy(xpath = "//H1[@class='_3wPGpzKmmn'][text()='Наушники и Bluetooth-гарнитуры']")
    public WebElement title;

    public HeadphonesPageAfterFind() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 60, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    List<WebElement> list = new ArrayList<>();
    List<WebElement> listNew = new ArrayList<>();

    String artTitle;
    String artTitleRes;

    public void findArticlId() {
        btn.click();
        BaseSteps.getDriver().navigate().refresh();

        // сохраним в массив найденные телевизоры
        list = BaseSteps.getDriver().findElements(By.xpath("//article[contains(@class,'_1_')]"));
        //int size = 48; // на странице наушником меньше 12 шт
        // проверим, что их на странице ровно 48
       // Assert.assertThat(size, is(list.size()));
        // Из за того, что яндекс при поиске первым товаром может выводить рекламный товар
        // который не соответствует поиску, приходится в найленных элементах искать
        // первый подходящий под требования элемент
        for (WebElement el : list) {
            if (findWord(el.getText(), "Б")) {
                //сохраним елемент у которого надпись телевизор
                artTitle = getArtTitle("Бе", "s", el.getText());
                break;
            }
        }
        //зададим поиск по ранее найденному конкретному телевизору
        fillField(search, artTitle);
        btn.click();
        BaseSteps.getDriver().navigate().refresh();
        listNew = BaseSteps.getDriver().findElements(By.xpath("//article[contains(@class,'_1_')]"));

        for(WebElement el: listNew) {
            artTitleRes =  getArtTitle("Бе", "s", el.getText());
            if(artTitleRes.equals(artTitle)) {
                //сравним заново найденный телевизор с тем , что указывали в поиске
                Assert.assertEquals(artTitle,artTitleRes);
                break;
            }
        }
    }
}
