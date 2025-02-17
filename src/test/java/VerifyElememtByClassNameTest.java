import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyElememtByClassNameTest {

    public VerifyElememtByClassNameTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.className("btn"));
            assertTrue(element1.isDisplayed(), "Element should be displayed");
            assertTrue(element1.isEnabled(), "Element should be Enabled");
                               
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
