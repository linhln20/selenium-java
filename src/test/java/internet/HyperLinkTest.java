package internet;

import internet.pages.HyperLinkpage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class HyperLinkTest {
    HyperLinkpage hyperlinkpage;
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        hyperlinkpage = new HyperLinkpage();
        hyperlinkpage.open();
    }
    @Test
     void hyperLink(){
        hyperlinkpage.clickLink("200");
        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        Browser.back();

        hyperlinkpage.clickLink("301");
        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        Browser.back();

        hyperlinkpage.clickLink("404");
        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        Browser.back();

        hyperlinkpage.clickLink("500");
        Assert.assertEquals(Browser.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        Browser.back();
    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
