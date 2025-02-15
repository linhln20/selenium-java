package internet;

import internet.pages.HyperLinkpage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class HyperLinkTest {
    /**
     * TC04: Hyper link : Hyperlink - link text
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/status_codes
     * Click on "200"
     * Then "200 status code" page appear
     * Click on "go here"
     * Click on "301"
     * Then "301 status code" page appear
     * Click on "go here"
     * Click on "404"
     * Then "404 status code" page appear
     * Click on "go here"
     * Click on "500"
     * Then "500 status code" page appear
     * Click on "go here"
     */
    @Test
     void hyperLink(){
        Browser.openBrowser("chrome");
        HyperLinkpage hyperlinkpage = new HyperLinkpage();
        hyperlinkpage.open();

        //<a href="status_codes/200">200</a> ==> hyperlink element
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
}
