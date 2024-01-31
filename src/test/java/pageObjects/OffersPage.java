package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OffersPage
{
    public WebDriver driver;
    private  By searchField = By.id("search-field");
    private By foundProduct = By.xpath("//tbody/tr/td[1]");
    public OffersPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchForProduct(String productName)
    {
      driver.findElement(searchField).sendKeys(productName);
    }

    public String getProductName()
    {
       return driver.findElement(foundProduct).getText();
    }

}
