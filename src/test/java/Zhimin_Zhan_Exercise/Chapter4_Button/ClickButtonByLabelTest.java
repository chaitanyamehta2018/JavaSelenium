package Zhimin_Zhan_Exercise.Chapter4_Button;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickButtonByLabelTest {

    public ClickButtonByLabelTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/button.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));             
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'Choose Selenium')]"));
            assertTrue(element1.isDisplayed(),"Button should be displayed");
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
