package pages;

import config.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    public LoginTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void getUrl() throws IOException {
        ConfigData data = new ConfigData();
        String url = data.retrunPropertyValue("url");
        driver.get(url);
    }
    public void enterUserAndPwd(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();
    }
}
