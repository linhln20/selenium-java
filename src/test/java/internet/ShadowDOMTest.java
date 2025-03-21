package internet;

import internet.pages.ShadowDOMPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class ShadowDOMTest {
    ShadowDOMPage shadowDOMPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        shadowDOMPage = new ShadowDOMPage();
        shadowDOMPage.open();
    }

    @Test (groups = {"wip"})
    void verifyShadowDOMText() {
        Assert.assertEquals(shadowDOMPage.getShadowDOMText(), "Let's have some different text!");
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }

}
