package internet;

import internet.pages.CaptureScreenShotPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class CaptureScreenShot {
    CaptureScreenShotPage captureScreenShotPage;
    @Parameters ({"browser", "url"})
    @BeforeMethod
    void setup(String browser, String url) {
        openBrowser(browser);
        captureScreenShotPage = new CaptureScreenShotPage();
        captureScreenShotPage.open(url + "/context_menu");
    }

    @Test
    void captureScreenShot() {
        captureScreenShotPage.captureScreenShot();
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
