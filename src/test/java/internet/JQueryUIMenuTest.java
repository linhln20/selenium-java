package internet;

import internet.pages.JQueryUIMenuPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.*;

public class JQueryUIMenuTest {
    JQueryUIMenuPage jQueryUIMenuPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        jQueryUIMenuPage = new JQueryUIMenuPage();
        jQueryUIMenuPage.open();
    }

    @Test (groups = {"wip"})
    void verifyUnableClickDisabled() {
        jQueryUIMenuPage.clickDisabled();
        Assert.assertEquals(jQueryUIMenuPage.getUrl(), "https://the-internet.herokuapp.com/jqueryui/menu#");
    }

    @Test (groups = {"wip"})
    void verifyAbleClickPDFText() throws InterruptedException {
        jQueryUIMenuPage.clickEnabled();
        jQueryUIMenuPage.clickDownloads();
        jQueryUIMenuPage.clickPDFText();

        Assert.assertTrue(jQueryUIMenuPage.isFileDownloaded());
    }

    @Test
    void verifyAbleClickBackTo() {
        jQueryUIMenuPage.clickEnabled();
        jQueryUIMenuPage.clickBackTo();

        Assert.assertEquals(jQueryUIMenuPage.getUrl(), "https://the-internet.herokuapp.com/jqueryui");
        Assert.assertTrue(jQueryUIMenuPage.getContentJQueryUI().contains(" is many things, but one thing specifically that causes automation challenges is their set of Widgets"));
    }

    @AfterMethod
    void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}
