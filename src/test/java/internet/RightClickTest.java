package internet;

import internet.pages.RightClickPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class RightClickTest {
    RightClickPage rightClickPage;

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
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
