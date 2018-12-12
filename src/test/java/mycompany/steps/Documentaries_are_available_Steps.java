package mycompany.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mycompany.pageobjects.*;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

public class Documentaries_are_available_Steps {

    @Managed
    WebDriver driver;

    Properties properties;

    CategoriesPage categoriesPage;
    FactualCategoryPage factualCategoryPage;
    CookiePage cookiePage;

    @Before
    public void setupTestData() {
        String testDataFile = "src/test/resources/testdata/search.properties";
        properties = new Properties();
        try{
            properties.load( Files.newInputStream(Paths.get(testDataFile)));
        }catch(IOException ioe) {
            fail("Unable to load test data file : " + testDataFile );
        }
    }

    @Given("^user has navigated to hub categories page$")
    public void user_has_navigated_to_hub_categories_page() throws Exception {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.open();
        cookiePage = new CookiePage(driver);
        cookiePage.acceptCookiePolicyIfPresented();
        assertTrue(categoriesPage.isOnPage());
    }

    @When("^user selects Factual$")
    public void user_selects_Factual() throws Exception {
        categoriesPage.clickFactualLink();
        factualCategoryPage = new FactualCategoryPage(driver);
    }

    @Then("^user should see a list of documentaries$")
    public void user_should_see_a_list_of_documentaries() throws Exception {
        assertTrue(factualCategoryPage.isOnPage());
        assertTrue(factualCategoryPage.getNumOfDocumentariesListed() > 0);
    }
}
