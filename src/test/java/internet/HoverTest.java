package internet;

import internet.pages.HoverPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class HoverTest {
    HoverPage hoverPage;
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        HoverPage hoverPage = new HoverPage();
        hoverPage.open();
    }

    @Test
    void hoverToImage(){ //done
        hoverPage.hoverOverFirstImage();

        String image1Profile = hoverPage.getFirstImageProfileText();
        Assert.assertEquals(image1Profile,"name: user1");

    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
