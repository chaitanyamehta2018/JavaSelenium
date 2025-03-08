package Zhimin_Zhan_Exercise.Chapter4_Button;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickImageButtonTest {

    public ClickImageButtonTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/ImageButton.html");
            driver.manage().window().maximize();

            WebElement element1 = driver.findElement(By.xpath("//img[@src='button_image.png']"));
            assertTrue(element1.isDisplayed(),"Image Button should be displayed");
            
            WebElement element2 = driver.findElement(By.xpath("//input[@id='textInput']"));
            assertTrue(element2.isDisplayed(),"Text Editbox should be displayed");
            element2.sendKeys("Hello Everyone, Welcome..!!");
            
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
