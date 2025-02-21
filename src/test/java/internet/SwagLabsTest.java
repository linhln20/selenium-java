package internet;

import internet.pages.SwagLabsPages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class SwagLabsTest {
    SwagLabsPages swagLabsPages;

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        swagLabsPages = new SwagLabsPages();
        swagLabsPages.open();
    }

    @Test
    void errorWithInvalidUsername() {
        swagLabsPages.setUsername(By.id("user-name"), "standarduser");
        swagLabsPages.setPassword(By.id("password"), "secret_sauce");
        swagLabsPages.clickLoginBtn();
        Assert.assertEquals(Browser.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(swagLabsPages.contains());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
