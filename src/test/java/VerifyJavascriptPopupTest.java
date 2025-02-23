
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class VerifyJavascriptPopupTest {
    
    public VerifyJavascriptPopupTest(){
        
    }
    
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.manage().window().maximize();
            
            /*
            FluentWait is an advanced waiting mechanism in Selenium that provides more control over how WebDriver waits for an element to appear. 
            Unlike WebDriverWait, which waits for a fixed timeout before throwing an error, 
            FluentWait allows periodic polling and can ignore exceptions dynamically.
            */
            
            
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2)) // Maximum wait time
                    .pollingEvery(Duration.ofSeconds(1)) // Retry every 1 seconds
                    .ignoring(Exception.class); // Ignore minor errors like StaleElementReferenceException

            
            
            
            WebElement element1 = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
            assertTrue(element1.isDisplayed(), "Javascript alert should be displayed");
            element1.click();
            Alert alert1 = fluentWait.until(ExpectedConditions.alertIsPresent());
            var alertText1 = alert1.getText();
            assertEquals("I am a JS Alert", alertText1, "Alert text does not match");
            alert1.accept();
            assertEquals("You successfully clicked an alert",driver.findElement(By.id("result")).getText(),"Incorrect result text");
             
                       
            
            WebElement element2 = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
            assertTrue(element2.isDisplayed(), "Javascript confirm should be displayed");
            element2.click();
            Alert alert2 = fluentWait.until(ExpectedConditions.alertIsPresent());
            var alertText2 = alert2.getText();
            assertEquals("I am a JS Confirm", alertText2, "Alert text does not match");
            alert2.accept();
            assertEquals("You clicked: Ok",driver.findElement(By.id("result")).getText(),"Incorrect result text");
            
     
            
            element2.click();
            Alert alert3 = fluentWait.until(ExpectedConditions.alertIsPresent());
            var alertText3 = alert3.getText();                   
            assertEquals("I am a JS Confirm", alertText3, "Alert text does not match");
            alert3.dismiss();
            assertEquals("You clicked: Cancel",driver.findElement(By.id("result")).getText(),"Incorrect result text");
            
 
            WebElement element3 = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
            assertTrue(element3.isDisplayed(), "Javascript Prompt should be displayed");
            element3.click();
            Alert alert4 = fluentWait.until(ExpectedConditions.alertIsPresent());
            var alertText4 = alert4.getText();
            assertEquals("I am a JS prompt", alertText4, "Alert text does not match");
            alert4.sendKeys("My Name is Lakhan");
            alert4.accept();
            assertEquals("You entered: My Name is Lakhan",driver.findElement(By.id("result")).getText(),"Incorrect result text");

            
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
