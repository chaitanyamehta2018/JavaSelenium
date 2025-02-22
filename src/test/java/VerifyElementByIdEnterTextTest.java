
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyElementByIdEnterTextTest {
    
    public VerifyElementByIdEnterTextTest(){
        
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

            WebElement element1 = driver.findElement(By.id("username"));
            assertTrue(element1.isDisplayed(), "Username element should be visible");
            element1.sendKeys("student");
  
            WebElement element2 = driver.findElement(By.id("password"));
            assertTrue(element2.isDisplayed(), "Password element should be visible");
            element2.sendKeys("Password123");
                               
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
