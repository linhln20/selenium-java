package internet;

import internet.pages.JavaScriptAlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class JavaScriptAlert {
    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/javascript_alerts
     * When click on "Click For JS Alert" button
     * Then the Popup is displayed.
     */
    @Test
    void ableClickJSAlert() {
        Browser.openBrowser("chrome");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();

        javaScriptAlertPage.clickAlertBtn("Alert");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(), "You successfully clicked an alert");
        Browser.quit();
    }
    @Test
    void ableCancelJSConfirm(){
        Browser.openBrowser("chrome");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();

        javaScriptAlertPage.clickAlertBtn("Confirm");
        Browser.dismissAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(),"You clicked: Cancel");

        Browser.quit();
    }

    @Test
    void ableAcceptJSConfirm(){
        Browser.openBrowser("chrome");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();

        javaScriptAlertPage.clickAlertBtn("Confirm");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(),"You clicked: Ok");

        Browser.quit();
    }
    @Test
    void ableSendKeysInJSPrompt(){
        Browser.openBrowser("chrome");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.open();
        javaScriptAlertPage.clickAlertBtn("Prompt");



        javaScriptAlertPage.sentKey("hello");
        Browser.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(),"You entered: hello");

        Browser.quit();
    }

}
