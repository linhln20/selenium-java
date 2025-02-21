package internet;

import internet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.maximize;

public class HorizontalSliderTest {
    HorizontalSliderPage horizontalSliderPage;
    @Parameters({"browser","url"})
    @BeforeMethod
    void setUp(String browser, String url) {
        Browser.openBrowser(browser);
        maximize();
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open(url+"/horizontal_slider");
    }

    @Test
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
