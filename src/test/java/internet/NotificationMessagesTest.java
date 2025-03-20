package internet;

import internet.pages.NotificationMessagesPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class NotificationMessagesTest {
NotificationMessagesPage notificationMessagesPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
    notificationMessagesPage = new NotificationMessagesPage();
    notificationMessagesPage.open();
    }
        @Test
        void verifyNotificationMessages() {
        notificationMessagesPage.clickHere();
        Assert.assertTrue(notificationMessagesPage.getNotificationMessage().contains("Action successful"));
        }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
