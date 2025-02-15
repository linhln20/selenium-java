package internet;

import internet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class HorizontalSliderTest {
    @Test
    void horizontalSlider() throws InterruptedException {
        Browser.openBrowser("chrome");
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();

        horizontalSliderPage.getPointer();
        horizontalSliderPage.waitDuration();
        Assert.assertTrue(horizontalSliderPage.isSliderSetToValue());
        Browser.quit();
    }
}
