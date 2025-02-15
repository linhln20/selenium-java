package internet;

import internet.pages.HoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class HoverTest {
    @Test
    void hoverToImage(){ //done
        Browser.openBrowser("chrome");
        HoverPage hoverPage = new HoverPage();
        hoverPage.open();

        hoverPage.hoverOverFirstImage();

        String image1Profile = hoverPage.getFirstImageProfileText();
        Assert.assertEquals(image1Profile,"name: user1");
        Browser.quit();
    }
}
