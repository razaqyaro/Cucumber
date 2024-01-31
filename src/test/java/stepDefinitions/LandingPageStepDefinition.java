package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;




public class LandingPageStepDefinition
{
    public WebDriver driver;
    public String landingPageProductName;
    public String offersPageProductName;
    TestContextSetup testContextSetup;
    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productShortName) throws InterruptedException {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchItem(productShortName);
        Thread.sleep(3000);
        testContextSetup.landingPageProductName =  landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName);
    }



}
