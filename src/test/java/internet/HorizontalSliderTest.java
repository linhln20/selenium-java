package internet;

import internet.pages.horizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class HorizontalSliderTest {
    @Test
    void horizontalSlider() throws InterruptedException {
        Browser.openBrowser("chrome");
        horizontalSliderPage horizontalSliderPage = new horizontalSliderPage();
        horizontalSliderPage.open();

        horizontalSliderPage.getPointer();
        horizontalSliderPage.waitDuration();
        Assert.assertTrue(horizontalSliderPage.isSliderSetToValue());
        Browser.quit();
    }
}
