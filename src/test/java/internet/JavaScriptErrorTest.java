package internet;

import internet.pages.JavaScriptErrorPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.*;

public class JavaScriptErrorTest {
    JavaScriptErrorPage javaScriptErrorPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        javaScriptErrorPage = new JavaScriptErrorPage();
        javaScriptErrorPage.open();
    }

@Test
void verifyJavaScriptError(){
    Assert.assertTrue(javaScriptErrorPage.getConsoleErrors());
}

    @AfterMethod
    void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}
