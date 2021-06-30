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

public class TvPageAfterFind extends BasePage{
    @FindBy(xpath = "//*[contains(text(),'Выбор покупателей')]")
    public WebElement title;

    @FindBy(xpath = "//article[contains(@class,'_1_')]")
    public WebElement article;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    public WebElement search;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/noindex/div/div/div[2]/div[2]/div/form/div/button")
    public WebElement btn;


    public TvPageAfterFind() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 60, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }
    List<WebElement> list = new ArrayList<>();
    List<WebElement> listNew = new ArrayList<>();
    String articleID;
    String articleIDRes;
    String artTitle;
    String artTitleRes;
    List<String> stringList = new ArrayList<>();
    // метод для получения названия найденного телевизора
    public String getArtTitle(String begin, String finish, String art) {
        int start = art.indexOf(begin); // "Те"
        int end = art.indexOf(finish); // "\""
        char[] dst=new char[end - start];
        articleID.getChars(start, end, dst, 0);
        System.out.println(dst);
        return new String(dst);
    }


    public void findArticlId() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 60, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
        // сохраним в массив найденные телевизоры
        list = BaseSteps.getDriver().findElements(By.xpath("//article[contains(@class,'_1_')]"));
        int size = 48;
        // проверим, что их на странице ровно 48
        Assert.assertThat(size, is(list.size()));
        WebElement webArticl = list.get(1);
        System.out.println(list.size());
        articleID = webArticl.getText();
        artTitle =  getArtTitle("Те", "\"", articleID);
        //зададим поиск по ранее найденному конкретному телевизору
        fillField(search, artTitle);
        btn.click();
        wait.until(ExpectedConditions.visibilityOf(title));
        listNew = BaseSteps.getDriver().findElements(By.xpath("//article[contains(@class,'_1_')]"));
        articleIDRes = listNew.get(0).getText();
        artTitleRes =  getArtTitle("Те", "\"", articleIDRes);
        System.out.println("финальный результат");
        System.out.println("artTitle = " + artTitle);
        System.out.println("artTitleRes = " + artTitleRes);
        //сравним заново найденный телевизор с тем , что указывали в поиске
        Assert.assertEquals(artTitle,artTitleRes);
    }

}
