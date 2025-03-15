package internet;

import internet.pages.DigestAuthPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class DigestAuthTest {
DigestAuthPage digestAuthPage;
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        digestAuthPage = new DigestAuthPage();
        digestAuthPage.open();
    }

    @Test
    void loginSuccess(){
        Assert.assertTrue(digestAuthPage
                .getMessage()
                .contains("Congratulations! You must have the proper credentials."));
    }
    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
