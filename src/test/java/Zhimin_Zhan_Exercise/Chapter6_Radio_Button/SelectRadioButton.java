
package Zhimin_Zhan_Exercise.Chapter6_Radio_Button;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelectRadioButton {

    public SelectRadioButton()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/SelectRadioButton.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));
            
            driver.manage().window().maximize();
            
            
            //Finding Elements
             WebElement radioButton = driver.findElement(By.id("java"));
             radioButton.click();
             
             Thread.sleep(6000);
             radioButton.clear();
             //String multilineText = "This is line 1\nThis is line 2\nThis is line 3";
             
             //textArea.sendKeys(multilineText);
             //submitButton.click();
             
             // String displayedText = driver.findElement(By.id("output")).getText();
              //assertEquals(multilineText, displayedText.trim(), "Output text should match input text");            
            
            Thread.sleep(2000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
