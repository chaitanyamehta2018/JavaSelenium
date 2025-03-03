package Zhimin_Zhan_Exercise.Chapter3_Hyperlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            driver.get("file:///E:/Softwares/Java/JavaSelenium/src/test/java/Zhimin_Zhan_Exercise/SampleHTMLs/OpenGoogle.html");
            driver.manage().window().maximize();

            // Get the current window handle (main window)
            String mainWindow = driver.getWindowHandle();

            // Find and click the hyperlink
            WebElement link = driver.findElement(By.id("googleLink")); // Assuming the link has id="googleLink"
            link.click();

            // Wait for the new window to open
            Thread.sleep(3000);

            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            Iterator<String> iterator = allWindows.iterator();

            // Switch to the new window explicitly
            String firstWindow = iterator.next(); // Main window
            String secondWindow = iterator.next(); // New window

            driver.switchTo().window(secondWindow);

            // Verify new window URL
            assertEquals("https://www.google.com/", driver.getCurrentUrl(), "New window should be Google");

            // Close new window and switch back to the main window
            driver.close();
            driver.switchTo().window(mainWindow);

            Thread.sleep(2000);

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
