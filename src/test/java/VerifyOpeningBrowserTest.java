

import com.ats.javaselenium.JavaSelenium;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class VerifyOpeningBrowserTest {
    
    public VerifyOpeningBrowserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class JavaSelenium.
     */
    @Test
    public void testMain() throws InterruptedException 
    {
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("http://www.google.com");
        
        driver.manage().window().maximize();
        
        WebElement element = driver.findElement(By.name("q"));
        
        element.sendKeys("Sky Force Movie Trailer");
        
        element.submit();
                
        Thread.sleep(5000);
        
        driver.quit();
        
    }
    
}
