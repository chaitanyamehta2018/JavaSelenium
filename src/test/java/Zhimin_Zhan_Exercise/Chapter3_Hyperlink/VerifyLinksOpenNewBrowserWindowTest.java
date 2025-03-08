package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyLinksOpenNewBrowserWindowTest {

    @Test
    public void VerifyLinksOpenNewBrowserWindowTest() throws InterruptedException {
        WebDriver driver = null;

        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/OpenTestPage.html");
            driver.manage().window().maximize();

            // Step 1: Store the current page URL
            String currentUrl = driver.getCurrentUrl();

            // Step 2: Get the href (link URL) of the "Open new window" link
            String newWindowUrl = driver.findElement(By.linkText("Open new window")).getAttribute("href");

            // Step 3: Navigate to the new page within the same window
            driver.navigate().to(newWindowUrl);

            // Step 4: Perform an action on the new page
            driver.findElement(By.name("q")).sendKeys("Hello World");

            // Step 5: Return to the original page
            driver.navigate().to(currentUrl);

            // Validate we are back on the original page
            assertEquals(currentUrl, driver.getCurrentUrl(), "Should return to original page");

            Thread.sleep(4000);
        } 
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
