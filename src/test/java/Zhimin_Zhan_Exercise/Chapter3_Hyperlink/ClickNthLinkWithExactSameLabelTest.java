package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClickNthLinkWithExactSameLabelTest {

    public ClickNthLinkWithExactSameLabelTest()
    {
    }
        
    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            File file = new File("src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/SameLinkName.html");
            String filePath = file.getAbsolutePath();
            driver.get("file:///" + filePath.replace("\\", "/"));             
            driver.manage().window().maximize();

            var element1= driver.findElements(By.linkText("Show Answer"));
            assertTrue(element1.size()==8,"Element size should be 8");
            
            element1.get(0).click();
            var answer1 = driver.findElement(By.xpath("//*[text()='Answer: 4']"));
            assertTrue(answer1.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);
            
            element1.get(1).click();
            var answer2 = driver.findElement(By.xpath("//*[text()='Answer: Paris']"));
            assertTrue(answer2.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);

            element1.get(2).click();
            var answer3 = driver.findElement(By.xpath("//*[text()='Answer: William Shakespeare']"));
            assertTrue(answer3.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);

            element1.get(3).click();
            var answer4 = driver.findElement(By.xpath("//*[text()='Answer: Magan']"));
            assertTrue(answer4.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);

            element1.get(4).click();
            var answer5 = driver.findElement(By.xpath("//*[text()='Answer: H₂O']"));
            assertTrue(answer5.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);

            element1.get(5).click();
            var answer6 = driver.findElement(By.xpath("//*[text()='Answer: 7']"));
            assertTrue(answer6.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);

            element1.get(6).click();
            var answer7 = driver.findElement(By.xpath("//*[text()='Answer: Jupiter']"));
            assertTrue(answer7.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);            
            
            
            element1.get(7).click();
            var answer8 = driver.findElement(By.xpath("//*[text()='Answer: 299,792,458']"));
            assertTrue(answer8.isDisplayed(), "Answer1 test should be displayed");
            Thread.sleep(2000);
            
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
        
    }
    
}
