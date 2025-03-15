package internet;

import internet.pages.DynamicContentPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class DynamicContentTest {
    DynamicContentPage dynamicContentPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        dynamicContentPage = new DynamicContentPage();
        dynamicContentPage.open();
    }

    @Test
    void verifyContentChange() {
        String contentBefore = dynamicContentPage.getContent();
        dynamicContentPage.loadPage();

        String contentAfter = dynamicContentPage.getContent();
        Assert.assertNotEquals(contentAfter, contentBefore);
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
