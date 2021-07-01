package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class ElectricPage {
    //раздел телевизоры в разделе телевизоры на странице электроника
    @FindBy(xpath = "//A[@href='/catalog--televizory/18040671/list?hid=90639'][text()='Телевизоры']")
    public WebElement tv;
    //раздел беспроводные наушники в разделе наушники на странице электроника
    @FindBy(xpath = "//*[(text()='Беспроводные наушники')]")
    public WebElement headphones;

    @FindBy(xpath = "//*[contains(@class,'1Zj')]")
    public WebElement title;




    public ElectricPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}


