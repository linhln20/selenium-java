package internet;

import internet.pages.CaptureScreenShotPage;
import internet.pages.DynamicLoadingPage;
import internet.pages.KeyPressPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class KeyActionsTest {
    @Test
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

    @Test
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

    @Test
    void dynamicLoadingB() {
        Browser.openBrowser("chrome");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
        dynamicLoadingPage.click();

        dynamicLoadingPage.waitLoadB();
        Assert.assertEquals(dynamicLoadingPage.getText(),"Hello World!");
        Browser.quit();
    }

    @Test
    void captureScreenShot(){
        Browser.openBrowser("chrome");
        CaptureScreenShotPage captureScreenShotPage = new CaptureScreenShotPage();
        captureScreenShotPage.open();

        captureScreenShotPage.captureScreenShot();
        Browser.quit();
    }
}
