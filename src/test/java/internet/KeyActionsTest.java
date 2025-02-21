package internet;

import internet.pages.CaptureScreenShotPage;
import internet.pages.DynamicLoadingPage;
import internet.pages.KeyPressPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class KeyActionsTest {
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void keyPress() {
        KeyPressPage keyPressPage = new KeyPressPage();
        keyPressPage.open();

        keyPressPage.keyControl();
        System.out.println(keyPressPage.getResult());
        keyPressPage.keyA();
        System.out.println(keyPressPage.getResult());

        keyPressPage.keyEnter();
        System.out.println(keyPressPage.getResult());
    }

    @Test
    void dynamicLoading() throws InterruptedException {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();

        dynamicLoadingPage.click();

//        Thread.sleep(5000);
//        Assert.assertEquals(driver.findElement(By.id("finish")).getText(),"Hello World!");
        dynamicLoadingPage.waitLoad();
        Assert.assertEquals(dynamicLoadingPage.getText(), "Hello World!");

    }

    @Test
    void dynamicLoadingB() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
        dynamicLoadingPage.click();

        dynamicLoadingPage.waitLoadB();
        Assert.assertEquals(dynamicLoadingPage.getText(), "Hello World!");
    }

    @Test
    void captureScreenShot() {
        CaptureScreenShotPage captureScreenShotPage = new CaptureScreenShotPage();
        captureScreenShotPage.open();

        captureScreenShotPage.captureScreenShot();
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
