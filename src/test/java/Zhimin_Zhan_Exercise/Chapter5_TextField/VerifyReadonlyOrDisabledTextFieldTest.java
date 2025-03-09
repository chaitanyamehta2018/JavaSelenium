package Zhimin_Zhan_Exercise.Chapter5_TextField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyReadonlyOrDisabledTextFieldTest {

    public VerifyReadonlyOrDisabledTextFieldTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/ReadonlyOrDisabledTextField.html");
            driver.manage().window().maximize();
            
            
            var readonlyBox = driver.findElement(By.id("readonlyField"));
            var disabledBox = driver.findElement(By.id("disabledField"));
            
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            
            jse.executeScript("arguments[0].removeAttribute('readonly'); arguments[0].value='Hello';", readonlyBox);
            jse.executeScript("arguments[0].removeAttribute('disabled'); arguments[0].value='Folks'; arguments[0].dispatchEvent(new Event('change'));", disabledBox);

            var readonlyBoxText = readonlyBox.getAttribute("value");
            var disabledBoxText = disabledBox.getAttribute("value");
             
            
           assertEquals("Hello", readonlyBoxText, "Text Should be matched");
           assertEquals("Folks", disabledBoxText, "Text Should be matched");  
            
            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
