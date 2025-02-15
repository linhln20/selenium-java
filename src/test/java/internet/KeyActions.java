package internet;

import internet.pages.CaptureScreenShotPage;
import internet.pages.DynamicLoadingPage;
import internet.pages.KeyPressPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class KeyActions {
    @Test //done
    void keyPress(){
        Browser.openBrowser("chrome");
        KeyPressPage keyPressPage = new KeyPressPage();
        keyPressPage.open();

        keyPressPage.keyControl();
        System.out.println(keyPressPage.getResult());
        keyPressPage.keyA();
        System.out.println(keyPressPage.getResult());

        keyPressPage.keyEnter();
        System.out.println(keyPressPage.getResult());
        Browser.quit();
    }

    @Test //done
    void dynamicLoading() throws InterruptedException {
        Browser.openBrowser("chrome");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();

        dynamicLoadingPage.click();

//        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement(By.id("finish")).getText(),"Hello World!");
        dynamicLoadingPage.waitLoad();
        Assert.assertEquals(dynamicLoadingPage.getText(),"Hello World!");

        Browser.quit();
    }

    @Test //done
    void dynamicLoadingB() {
        Browser.openBrowser("chrome");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
        dynamicLoadingPage.click();

        dynamicLoadingPage.waitLoadB();
        Assert.assertEquals(dynamicLoadingPage.getText(),"Hello World!");
        Browser.quit();
    }

    @Test //done
    void captureScreenShot(){
        Browser.openBrowser("chrome");
        CaptureScreenShotPage captureScreenShotPage = new CaptureScreenShotPage();
        captureScreenShotPage.open();

        captureScreenShotPage.captureScreenShot();
        Browser.quit();
    }
}
