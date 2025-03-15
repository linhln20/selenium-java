package internet;

import internet.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class ContextMenuTest {
    ContextMenuPage contextMenuPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        contextMenuPage = new ContextMenuPage();
        contextMenuPage.open();
    }

    @Test
    void rightClick(){
        contextMenuPage.clickRight();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
