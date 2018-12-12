package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnPage() {
        return true;
    }
}
