package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import XPath.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyLinksOpenNewBrowserWindowTest {

    public VerifyLinksOpenNewBrowserWindowTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.xpath("//input[@title ='Search for Products, Brands and More' and @name ='q']"));
            assertTrue(element1.isDisplayed(), "Element should be displayed");
            element1.sendKeys("Wrist watch");
            element1.sendKeys(Keys.ENTER);
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
