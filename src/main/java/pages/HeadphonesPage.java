package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class HeadphonesPage extends BasePage {

    @FindBy(xpath = "//H1[@class='_3wPGpzKmmn'][text()='Беспроводные наушники']")
    public WebElement title;

    @FindBy(xpath = "//DIV[@class='LhMupC0dLR']//*[contains(text(),'Beats')]"
    )
    public WebElement beats;


    public HeadphonesPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Beats":
                beats.click();
                break;
            case "Цена от":
                fillField(priceFrom, value);
                break;
            case "Сортировка по цкне":
                sortPrice.click();
                break;
        }
    }
}
