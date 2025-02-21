package internet;

import internet.pages.NestedFrameTestPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class NestedFrameTest {
    NestedFrameTestPage nestedFrameTestPage;

    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        nestedFrameTestPage = new NestedFrameTestPage();
        nestedFrameTestPage.open(url+"/nested_frames");
    }

    @Test
    void verifyNestedFrameContent() {
        nestedFrameTestPage.swithFame("frame-top");
        nestedFrameTestPage.swithFame("frame-left");
        nestedFrameTestPage.contains("LEFT");

        nestedFrameTestPage.swithParentFame();
        nestedFrameTestPage.swithFame("frame-middle");
        nestedFrameTestPage.contains("MIDDLE");

        nestedFrameTestPage.swithParentFame();
        nestedFrameTestPage.swithFame("frame-right");
        nestedFrameTestPage.contains("RIGHT");

        nestedFrameTestPage.swithToDefaultContent();
        nestedFrameTestPage.swithFame("frame-bottom");
        nestedFrameTestPage.contains("BOTTOM");
    }
@AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
