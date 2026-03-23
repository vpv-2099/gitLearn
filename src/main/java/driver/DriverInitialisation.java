package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverInitialisation {
    WebDriver driver;
    WebDriverWait wait;

    public WebDriver initDriver() {
        ChromeOptions options = new ChromeOptions();

        // ✅ Detect Docker (Chromium) vs Local (Chrome)
        String chromeBin = System.getenv("CHROME_BIN");
        if (chromeBin != null && !chromeBin.isEmpty()) {
            options.setBinary(chromeBin); // used in Docker
        }

        // ✅ Headless support
        String headless = System.getProperty("headless");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
        }

        // ✅ Required for Docker stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // ✅ Optional but useful
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // ✅ Disable Chrome popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        // ⚠️ Avoid maximize in headless (can fail in Docker)
        if (!"true".equalsIgnoreCase(headless)) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    public WebDriverWait initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
}