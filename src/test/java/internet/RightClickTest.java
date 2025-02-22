package internet;

import internet.pages.RightClickPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;
import static supports.Browser.openBrowser;

public class RightClickTest {
    RightClickPage rightClickPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        rightClickPage = new RightClickPage();
        rightClickPage.open();
    }

    @Test
    void rightClick() {
        rightClickPage.rightClick();
        Browser.acceptAlert();
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
