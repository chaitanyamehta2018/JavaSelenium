package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import java.io.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GettingLinkDataAttributesTest {

    public GettingLinkDataAttributesTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/verify_link_attributes.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));             
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.id("testLink"));
            
            
            var hrefValue =element1.getAttribute("href");
            assertEquals("https://www.example.com/", hrefValue, "Href attribute does not match");

            var targetValue = element1.getAttribute("target");
            assertEquals("_blank", targetValue, "Href attribute does not match");            


            var linktext = element1.getText();
            assertEquals("Click Here", linktext, "Href attribute does not match");                   
           
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
