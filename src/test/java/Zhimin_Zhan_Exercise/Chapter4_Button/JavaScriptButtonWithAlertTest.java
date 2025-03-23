package Zhimin_Zhan_Exercise.Chapter4_Button;

import java.io.File;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptButtonWithAlertTest {

    public JavaScriptButtonWithAlertTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/ButtonViaJavaScript.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/")); 
            driver.manage().window().maximize();
            
            //Created Explicit wait of 5 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            
            //Finding Button
            WebElement element1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
            assertTrue(element1.isDisplayed(),"Button should be displayed");
            String  element1Text= element1.getText();
            assertTrue("Click Me".equals(element1Text),"Button Text Should be matched");
            element1.click();
            
            //Verify and Handling Alert
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            String alert1Text = alert1.getText();
            assertTrue("Button Clicked!".equals(alert1Text),"Button Text Should be matched");
            alert1.accept();
            
            
            Thread.sleep(2000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
