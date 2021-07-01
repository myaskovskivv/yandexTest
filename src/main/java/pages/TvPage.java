package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class TvPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"search-prepack\"]/div/div/div/div/div[2]/div[5]/div/div/fieldset/legend")
    public WebElement title;

    @FindBy(xpath = "//DIV[@class='LhMupC0dLR']//*[contains(text(),'Samsung')]"
    )
    public WebElement samsung;

    @FindBy(xpath = "//DIV[@class='LhMupC0dLR']//*[contains(text(),'LG')]"
    )
    public WebElement Lg;

    @FindBy(xpath =   "//*[contains(@class,'_3JNss')]//*[contains(@class,'vLDMfaby')]"
    )
    public WebElement sortSumElement;

    @FindBy(xpath = "//BUTTON[@class='_1KpjX8xME8 _35PaznpQ-g'][text()='Показывать по 12']"
    )
    public WebElement sortSumElement12;





    public TvPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Самсунг":
                samsung.click();
                break;
            case "LG":
                Lg.click();
                break;
            case "Цена от":
                fillField(priceFrom, value);
                break;
            case "Сортировка по цкне":
                sortPrice.click();
                break;
            case "Кол во элементов на странице":
                sortSumElement.click();
                break;
            case "Кол во элементов на странице 12":
               // new WebDriverWait(BaseSteps.getDriver(), 45, 1000).until(ExpectedConditions.visibilityOf(sortSumElement12)).click();
                sortSumElement12.click();
                break;
        }
    }
}
