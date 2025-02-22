package internet;

import internet.pages.ScrollDownPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;
import static supports.Browser.openBrowser;

public class ScrollDownTest {
    ScrollDownPage scrollDownPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        scrollDownPage = new ScrollDownPage();
        scrollDownPage.open();
    }

    @Test
    void scrollDown() throws InterruptedException {
        scrollDownPage.scrollDown();
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
