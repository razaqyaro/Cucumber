package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsManager
{
    public WebDriver driver;
    public WindowsManager(WebDriver driver)
    {
        this.driver = driver;
    }
    public void switchToOffersPage()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowsIterator = windows.iterator();
        String parentWindow = windowsIterator.next();
        String childWindow = windowsIterator.next();
        driver.switchTo().window(childWindow);
    }
}
