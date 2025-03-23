package Zhimin_Zhan_Exercise.Chapter4_Button;

import java.io.File;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

public class ConditionalButtonTest {

    public ConditionalButtonTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/Conditional_Button.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));             
            driver.manage().window().maximize();
            
            //Created Explicit wait of 5 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            
            //Finding Button
            WebElement element1 = driver.findElement(By.xpath("//button[@id='submitButton']"));
            assertFalse(element1.isEnabled(),"Button should  NOT be enabled");
            String  element1Text= element1.getText();
            assertTrue("Submit".equals(element1Text),"Button Text Should be matched");
            
            
            //Check the text edit box
            WebElement element2 = driver.findElement(By.xpath("//input[@id=\'textInput\']"));
            assertTrue(element2.isDisplayed(),"Text Edit box should be displayed");
            
            //Enter text and check whether Button enabled
            element2.sendKeys("Hello Folks");
            assertTrue(element1.isEnabled(),"Button should  be enabled now");
            
            //After clicking button, check the Alert and its texts
            element1.click();
            Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
            String alert1Text = alert1.getText();
            assertTrue("You entered: Hello Folks".equals(alert1Text),"Alert Text Should be matched");
            alert1.accept();
            
            //once more check for the Button whether enabled or not
            assertTrue(element1.isEnabled(),"Button should  be enabled now");
            
            
            Thread.sleep(2000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
