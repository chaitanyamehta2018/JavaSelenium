package Zhimin_Zhan_Exercise.Chapter4_Button;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickFormTextButtonTest {

    public ClickFormTextButtonTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/FormButton.html");
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.xpath("//input[@id='textInput']"));
            assertTrue(element1.isDisplayed(),"Text Editbox should be displayed"); 
            element1.sendKeys("Wish you a very Happy Testing");
            
            WebElement element2 = driver.findElement(By.xpath("//button[@id='submitButton']"));
            assertTrue(element2.isDisplayed(),"Button should be displayed");
            element2.click();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='output']")));
            String  outputtext =element3.getText();
            assertTrue("You entered: Wish you a very Happy Testing".equals(outputtext),"Output Text should be displayed");
            
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
