package internet;

import internet.pages.HoverPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class HoverTest {
    HoverPage hoverPage;
    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        hoverPage = new HoverPage();
        hoverPage.open(url+"/hovers");
    }

    @Test
    void hoverToImage(){
        hoverPage.hoverOverFirstImage();

        String image1Profile = hoverPage.getFirstImageProfileText();
        Assert.assertEquals(image1Profile,"name: user1");

    }
    @AfterMethod
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
