package mycompany.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FactualCategoryPage extends PageObject {



    @FindBy(css = "#categories-list > ul > li")
    public List<WebElement> docu_list;

    public FactualCategoryPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnPage() {
        return containsText("Factual");
    }
    public int getNumOfDocumentariesListed(){
        return docu_list.size();
    }
}
