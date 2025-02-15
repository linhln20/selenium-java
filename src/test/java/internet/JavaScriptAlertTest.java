package internet;

import internet.pages.JavaScriptAlertPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class JavaScriptAlertTest {
    JavaScriptAlertPage javaScriptAlertPage;

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();
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
        Browser.openBrowser("chrome");
        javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();

        javaScriptAlertPage.clickAlertBtn("Confirm");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You clicked: Ok");
    }

    @Test
    void ableSendKeysInJSPrompt() {
        Browser.openBrowser("chrome");
        javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();
        javaScriptAlertPage.clickAlertBtn("Prompt");

        javaScriptAlertPage.sentKey("hello");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You entered: hello");
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
