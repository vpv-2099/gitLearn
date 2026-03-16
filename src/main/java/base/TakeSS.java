package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeSS {
    WebDriver driver;

    public TakeSS(WebDriver driver) {
        this.driver = driver;{
        }
    }

    public void takeSS() throws IOException {
        long timestamp = System.currentTimeMillis();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/test/Screenshots/" + timestamp + ".png"));
    }
}
