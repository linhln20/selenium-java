package internet;

import internet.pages.HyperLinkPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class HyperLinkTest {
    HyperLinkPage hyperlinkpage;
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        hyperlinkpage = new HyperLinkPage();
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
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
