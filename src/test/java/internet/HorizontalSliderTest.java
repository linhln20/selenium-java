package internet;

import internet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class HorizontalSliderTest {
    HorizontalSliderPage horizontalSliderPage;

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("edge");
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();
    }

    @Test //(groups = {"wip"})
    void horizontalSlider() throws InterruptedException {
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
