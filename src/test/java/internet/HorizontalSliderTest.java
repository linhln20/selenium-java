package internet;

import internet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class HorizontalSliderTest {
    HorizontalSliderPage horizontalSliderPage;
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("firefox");
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();
    }
    @Test
    void horizontalSlider() throws InterruptedException {
        horizontalSliderPage.getPointer();
        horizontalSliderPage.waitDuration();
        Assert.assertTrue(horizontalSliderPage.isSliderSetToValue());

    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
