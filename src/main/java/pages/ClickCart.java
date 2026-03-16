package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickCart {
    WebDriver driver;
    public ClickCart(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCart(){
        By cssSelector = By.cssSelector(".shopping_cart_link");
        driver.findElement(cssSelector).click();
    }
}
