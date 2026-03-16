package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver,  WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectProduct(String productName){
        switch (productName) {
            case "Sauce Labs Backpack" -> {
                By name = By.name("add-to-cart-sauce-labs-backpack");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
            }
            case "Sauce Labs Bike Light" -> {
                By name = By.name("add-to-cart-sauce-labs-bike-light");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
            }
            case "Sauce Labs Bolt T-Shirt" -> {
                By name = By.name("add-to-cart-sauce-labs-bolt-t-shirt");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
                System.out.println("New Change");
            }
            case "Sauce Labs Fleece Jacket" -> {
                By name = By.name("add-to-cart-sauce-labs-fleece-jacket");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
            }
            case "Sauce Labs Onesie" -> {
                By name = By.name("add-to-cart-sauce-labs-onesie");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
            }
            default -> {
                By name = By.name("add-to-cart-test.allthethings()-t-shirt-(red)");
                wait.until(ExpectedConditions.elementToBeClickable(name));
                driver.findElement(name).click();
            }
        }
    }
}
