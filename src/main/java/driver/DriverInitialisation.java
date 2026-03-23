package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverInitialisation {
    WebDriver driver;
    WebDriverWait wait;

    public WebDriver initDriver() {
        ChromeOptions options = new ChromeOptions();

        // ✅ Headless support
        String headless = System.getProperty("headless");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
        }

        // ✅ Common args (safe for both local & Docker)
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // ✅ Required for Docker stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // ✅ Disable Chrome popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        try {
            // ✅ Detect if running inside Docker (Jenkins)
            String seleniumRemoteUrl = System.getenv("SELENIUM_REMOTE_URL");

            if (seleniumRemoteUrl != null && !seleniumRemoteUrl.isEmpty()) {
                // 🔥 RUN IN DOCKER (Remote Selenium)
                System.out.println("Running in Docker using RemoteWebDriver...");

                driver = new RemoteWebDriver(
                        new URL(seleniumRemoteUrl),
                        options
                );
            } else {
                // 💻 RUN LOCALLY
                System.out.println("Running locally using ChromeDriver...");

                driver = new ChromeDriver(options);
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }

        // ⚠️ Avoid maximize in headless
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