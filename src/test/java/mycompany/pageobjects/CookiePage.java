package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePage extends PageObject {

    @FindBy(css="#cookie-message-accept")
    public WebElement cookieAccept_bt;

    public CookiePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiePolicyIfPresented() {
       if(cookieAccept_bt.isDisplayed()) {
           cookieAccept_bt.click();
       }
    }
}
