package internet;

import internet.pages.EntryAdPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class EntryAdTest {
    EntryAdPage entryAdPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        entryAdPage = new EntryAdPage();
        entryAdPage.open();
    }

    @Test
    void VerifyModalExit(){
        Assert.assertTrue(entryAdPage.getModal().isDisplayed());
    }

    @Test
    void VerifyModalCanClose(){
        entryAdPage.getModal();
        entryAdPage.closeModal();
        Assert.assertTrue(entryAdPage.isModalClose());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
