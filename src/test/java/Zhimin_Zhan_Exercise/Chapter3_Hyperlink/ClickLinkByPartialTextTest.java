package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import java.io.File;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickLinkByPartialTextTest {

    public ClickLinkByPartialTextTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/ClickLinkByIDTest.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));               
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.partialLinkText("Go to Exam"));
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
