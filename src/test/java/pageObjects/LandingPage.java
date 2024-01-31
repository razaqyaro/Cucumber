package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WindowsManager;




public class LandingPage {
    private By search = By.cssSelector("[placeholder='Search for Vegetables and Fruits']");
    private By productName = By.cssSelector("h4.product-name");
    private By offerPagelink = By.linkText("Top Deals");
    public WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }
    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }
    public void getSearchText()
    {
        driver.findElement(search).getText();
    }
    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public WindowsManager getWindowManager()
    {
        return new WindowsManager(driver);
    }
    public OffersPage gotoOfferPage()
    {
        driver.findElement(offerPagelink).click();
        getWindowManager().switchToOffersPage();
        return new OffersPage(driver);

    }


}