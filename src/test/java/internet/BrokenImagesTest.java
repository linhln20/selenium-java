package internet;

import internet.pages.BrokenImagesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

import static supports.Browser.openBrowser;

public class BrokenImagesTest {
    BrokenImagesPage brokenImagesPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage.open();
    }

    @Test
    void verifyBrokenImage() {
        Assert.assertTrue(brokenImagesPage
                .isImagesBroken(By.xpath("//div/img")));
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}