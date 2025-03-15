package internet;

import internet.pages.ExitIntentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import java.awt.*;

import static supports.Browser.openBrowser;
import static supports.Browser.quit;

public class ExitIntentTest {
    ExitIntentPage exitIntentPage;


    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        exitIntentPage = new ExitIntentPage();
        exitIntentPage.open();
    }

    @Test (groups = {"wip"})
    void verifyModalAppearsOnMouseExit() throws AWTException {
        exitIntentPage.moveMouseOutOfScreen();

        Assert.assertTrue(exitIntentPage.getModal().isDisplayed());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
