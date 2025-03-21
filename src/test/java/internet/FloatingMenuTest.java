package internet;

import internet.pages.FloatingMenuPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class FloatingMenuTest {
    FloatingMenuPage floatingMenuPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        floatingMenuPage = new FloatingMenuPage();
        floatingMenuPage.open();
    }

    @Test
    void verifyFloatingMenuVisibility() {
        WebElement floatMenu = floatingMenuPage.getFloatingMenu();
        Assert.assertTrue(floatingMenuPage.getFloatingMenu().isDisplayed());
    }

    @Test
    void verifyFloatingMenuStaysVisible() {
        floatingMenuPage.scroll();
        Assert.assertTrue(floatingMenuPage.getFloatingMenu().isDisplayed());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
