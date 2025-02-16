import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifySearchResultCountTest {

    public VerifySearchResultCountTest() { }

    @BeforeAll
    public static void setUpClass() { }

    @AfterAll
    public static void tearDownClass() { }

    @BeforeEach
    public void setUp() { }

    @AfterEach
    public void tearDown() { }

    @Test
    public void testMain() throws InterruptedException {
        WebDriver driver = null;
        
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("http://www.google.com");
            driver.manage().window().maximize();

            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Java Selenium Testing");
            element.submit();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));

            var searchResults = driver.findElements(By.cssSelector("h3"));
            var count = searchResults.size();

            System.out.println("Number of search results found: " + count);

            assertTrue(count > 0, "There should be greater than 0 search results");

            Thread.sleep(5000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
