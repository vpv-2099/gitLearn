package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterInfo {
    WebDriver driver;
    WebDriverWait wait;
    public EnterInfo(WebDriver driver,  WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterData(){
        By firstName = By.id("first-name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        driver.findElement(firstName).sendKeys("John");
        By lastName = By.id("last-name");
        driver.findElement(lastName).sendKeys("Doe");
        By postalCode = By.id("postal-code");
        driver.findElement(postalCode).sendKeys("12345");
        By id = By.id("continue");
        driver.findElement(id).click();
    }
}
