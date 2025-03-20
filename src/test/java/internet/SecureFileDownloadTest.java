package internet;

import internet.pages.SecureFileDownloadPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class SecureFileDownloadTest {
    SecureFileDownloadPage secureFileDownloadPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        secureFileDownloadPage = new SecureFileDownloadPage();
        secureFileDownloadPage.open();
    }

@Test
void verifyDownloadFile() throws InterruptedException {
    secureFileDownloadPage.clickDownloadFile();
    secureFileDownloadPage.isFileDownload();
}

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
