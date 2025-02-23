
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class VerifyUploadPopupTest {
    
    public VerifyUploadPopupTest(){
        
    }
    
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("https://the-internet.herokuapp.com/upload");
            driver.manage().window().maximize();
            
            
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5)) // Maximum wait time
                    .pollingEvery(Duration.ofSeconds(1)) // Retry every 1 second
                    .ignoring(Exception.class);
            
            
            var browsebutton = driver.findElement(By.id("file-upload"));
            browsebutton.sendKeys("C:\\Users\\HerryPotter\\Pictures\\man.jpg");
            
            var uploadButton  = driver.findElement(By.id("file-submit"));
            uploadButton.click();
            
            var successMessage   = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
            assertEquals("man.jpg",successMessage.getText(),"Incorrect SuccessMessage");

            
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
