package internet;

import internet.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;
import static supports.Browser.quit;

public class DynamicLoadingTest {
    DynamicLoadingPage dynamicLoadingPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser) {
        openBrowser(browser);
        dynamicLoadingPage = new DynamicLoadingPage();

    }

    @Test
    void ElementIsHidden() throws InterruptedException {
        dynamicLoadingPage.openExp1();
        dynamicLoadingPage.click();
        dynamicLoadingPage.waitLoad();

        Assert.assertEquals(dynamicLoadingPage.getText(), "Hello World!");
    }

    @Test
    void ElementRenderedAfterTheFact(){
        dynamicLoadingPage.openExp2();
        dynamicLoadingPage.click();
        dynamicLoadingPage.waitLoad();
        Assert.assertEquals(dynamicLoadingPage.getText(), "Hello World!");
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        quit();
    }
}
