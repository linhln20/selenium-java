package internet;

import internet.pages.ShiftingContentPage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class ShiftingContentTest {
    ShiftingContentPage shiftingContentPage;

    @Parameters ({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        shiftingContentPage = new ShiftingContentPage();
        shiftingContentPage.open();
    }

    @Test (groups = {"wip"})
    void verifyElementMenuLocation() {
        shiftingContentPage.clickExample1();
        Object beforeGalleryLocation = shiftingContentPage.getElementLocation();
        System.out.println(beforeGalleryLocation);
shiftingContentPage.clickModeRandom();
        Object afterGalleryLocation = shiftingContentPage.getElementLocation();
        System.out.println(afterGalleryLocation);
       Assert.assertNotEquals(beforeGalleryLocation, afterGalleryLocation);
    }
}
