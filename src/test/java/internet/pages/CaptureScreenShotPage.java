package internet.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import supports.Browser;

import java.io.File;
import java.io.IOException;

import static supports.Browser.visit;

public class CaptureScreenShotPage {
    public void open(String url){
        visit(url);
    }

    public void captureScreenShot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
