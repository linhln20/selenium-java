package internet;

import internet.pages.FileDownloaderPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static supports.Browser.openBrowser;
import static supports.Browser.quit;

public class FileDownloaderTest {
    FileDownloaderPage fileDownloaderPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        fileDownloaderPage = new FileDownloaderPage();
        fileDownloaderPage.open();
    }

    @Test (groups = {"wip"})
    void downloaderFile() throws InterruptedException {
        fileDownloaderPage.clickDownloadFile();
        fileDownloaderPage.isFileDownload();
    }
    @AfterMethod
    void tearDown() {
        quit();
    }
}
