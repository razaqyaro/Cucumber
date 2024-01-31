package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition
{
    public String offersPageProductName;
   TestContextSetup testContextSetup;
   public OfferPageStepDefinition(TestContextSetup testContextSetup)
   {
       this.testContextSetup = testContextSetup;
   }
    @Then("User searched for same {string} in offers page")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortname) throws InterruptedException {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        var offerPage = landingPage.gotoOfferPage();
        offerPage.searchForProduct(shortname);
        Thread.sleep(3000);
        offersPageProductName = offerPage.getProductName();
        System.out.println(offersPageProductName);

    }

    @And("Validate product name in landing page matches with that on landing page")
    public void validate_Product_Name_In_LandingPage_Matches_With_That_On_LandingPage()
    {
        Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName, "Product name on both landing page and offers page do not match");
        System.out.println(testContextSetup.landingPageProductName+" is extracted from the Offer Page");

    }
}
