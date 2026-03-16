package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickCheckout {
    WebDriver driver;
    WebDriverWait wait;
    public ClickCheckout(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickCart(){
        By cssSelector = By.cssSelector(".checkout_button");
        driver.findElement(cssSelector).click();
    }
}
