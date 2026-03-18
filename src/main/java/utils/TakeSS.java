package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeSS {
    WebDriver driver;

    public TakeSS(WebDriver driver) {
        this.driver = driver;{
        }
    }
    public void takeSS() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss_SSS");
        String formattedDate = LocalDateTime.now().format(formatter);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/test/Screenshots/" + formattedDate + ".png"));
    }
}
