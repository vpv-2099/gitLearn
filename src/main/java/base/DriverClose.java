package base;

import org.openqa.selenium.WebDriver;

public class DriverClose {
    WebDriver driver;
    public DriverClose(WebDriver driver) {
        this.driver = driver;
    }

    public void closeBrowser(){
        driver.close();
    }
    public void quitBrowser(){
        driver.quit();
    }
}
