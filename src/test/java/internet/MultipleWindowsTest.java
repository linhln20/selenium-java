package internet;

import internet.pages.MultipleWindowsPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class MultipleWindowsTest {
    MultipleWindowsPage multipleWindowsPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        multipleWindowsPage = new MultipleWindowsPage();
        multipleWindowsPage.open();
    }

    @Test
    void verifyMultipleWindows() {
        multipleWindowsPage.clickHere();
        assert multipleWindowsPage.getWindowHandles() > 1;
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
