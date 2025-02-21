package internet;

import internet.pages.JavaScriptAlertPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class JavaScriptAlertTest {
    JavaScriptAlertPage javaScriptAlertPage;

    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url) {
        openBrowser(browser);
        javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open(url + "/javascript_alerts");
    }

    @Test
    void ableClickJSAlert() {
        javaScriptAlertPage.clickAlertBtn("Alert");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You successfully clicked an alert");
    }

    @Test
    void ableCancelJSConfirm() {
        javaScriptAlertPage.clickAlertBtn("Confirm");
        Browser.dismissAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You clicked: Cancel");
    }

    @Test
    void ableAcceptJSConfirm() {
        javaScriptAlertPage.clickAlertBtn("Confirm");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You clicked: Ok");
    }

    @Test
    void ableSendKeysInJSPrompt() {
        javaScriptAlertPage.clickAlertBtn("Prompt");
        javaScriptAlertPage.sentKey("hello");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You entered: hello");
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
