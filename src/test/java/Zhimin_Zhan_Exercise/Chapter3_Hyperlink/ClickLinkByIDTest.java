package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickLinkByIDTest {

    public ClickLinkByIDTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/ClickLinkByIDTest.html");
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.id("sampleLink"));
            assertTrue(element1.isDisplayed(),"Element should be displayed");
            element1.click();
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
