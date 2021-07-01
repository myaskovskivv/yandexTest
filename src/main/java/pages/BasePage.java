package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(xpath = "//*[contains(text(),'по цене')]"
    )
    public WebElement sortPrice;

    @FindBy(xpath = "//INPUT[@id='glpricefrom']"
    )
    public WebElement priceFrom;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    public WebElement search;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/noindex/div/div/div[2]/div[2]/div/form/div/button")
    public WebElement btn;

    public void  fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    // метод определения что в описании элемента есть слово начинающееся на нужную букву
    public boolean findWord(String art, String w) {
        boolean res = false;
        if(art.contains(w)) {
            res = true;
        }
        return res;
    }
    // метод для получения названия найденного телевизора
    public String getArtTitle(String begin, String finish, String art) {
        int start = art.indexOf(begin); // "Те"
        int end = art.indexOf(finish); // "\""
        char[] dst=new char[end - start];
        art.getChars(start, end, dst, 0);
        System.out.println(dst);
        return new String(dst);
    }

}
