package internet;

import internet.pages.DisappearingElementsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class DisappearingElementsTest {
    DisappearingElementsPage disappearingElementsPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        disappearingElementsPage = new DisappearingElementsPage();
        disappearingElementsPage.open();
    }

    @Test
    public void testGalleryRandomness() {
        int iterations = 10;
        int galleryPresentCount = disappearingElementsPage.galleryCount();
        Assert.assertTrue(galleryPresentCount > 0 && galleryPresentCount < iterations);
    }
}
