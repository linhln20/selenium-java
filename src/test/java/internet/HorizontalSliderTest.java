package internet;

import internet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

public class HorizontalSliderTest {
    HorizontalSliderPage horizontalSliderPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        Browser.openBrowser(browser);
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();
    }

    @Test
    void horizontalSlider() {
        horizontalSliderPage.getPointer();

        Assert.assertTrue(horizontalSliderPage.isSliderSetToValue());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
