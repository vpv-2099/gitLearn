import base.DriverClose;
import base.DriverInitialisation;
import base.TakeSS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import java.io.IOException;

public class SampleTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws IOException {
        DriverInitialisation init = new DriverInitialisation();
        driver = init.initDriver();
        wait = init.initWait();
        LoginTest login = new LoginTest(driver, wait);
        login.getUrl();
        login.enterUserAndPwd("standard_user", "secret_sauce");
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
        login.clickLoginButton();
    }

    @DataProvider(name = "Select Product")
    public Object[] getData() {
    return new Object[] {"Sauce Labs Backpack", "Sauce Labs Fleece Jacket"};
    }

    @Test(dataProvider = "Select Product")
    public void sampleTest(String productName) throws IOException {
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.selectProduct(productName);
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
    }

    @Test
    public void sampleTest2() throws IOException {
        ClickCart clickCart =  new ClickCart(driver);
        clickCart.clickCart();
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
    }

    @Test
    public void sampleTest3() throws IOException {
        ClickCheckout clickCheckout = new ClickCheckout(driver, wait);
        clickCheckout.clickCart();
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
    }

    @Test
    public void sampleTest4() throws IOException {
        EnterInfo enterInfo = new EnterInfo(driver, wait);
        enterInfo.enterData();
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
    }

    @Test
    public void sampleTest5() throws IOException {
        LogOff logOff = new LogOff(driver, wait);
        logOff.logOff();
        TakeSS ss = new TakeSS(driver);
        ss.takeSS();
    }

    @AfterClass
    public void closure(){
        DriverClose close = new DriverClose(driver);
        close.closeBrowser();
        close.quitBrowser();
    }
}