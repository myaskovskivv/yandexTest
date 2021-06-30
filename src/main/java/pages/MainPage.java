package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    @FindBy(xpath = "//DIV[@class='_381y5orjSo _21NjfY1k45']")
    WebElement menuMain;


    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void selectMenuMine(String menuItem) {
        menuMain.findElement(By.xpath("//*[contains(@class,'_35SY')]//*[contains(@class,'_3Lwc')]//*[(text()='"+menuItem+"')]")).click();
    }

}
