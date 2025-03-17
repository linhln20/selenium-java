package internet;

import internet.pages.FileDownloaderPage;
import internet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class FileUploaderTest {
    FileUploaderPage fileUploaderPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        fileUploaderPage = new FileUploaderPage();
        fileUploaderPage.open();
    }

    @Test
    void VerifyUploadUsingChooseFile() {
        fileUploaderPage.uploadUsingChooseFile();
        Assert.assertTrue(fileUploaderPage.verifyUpload());
    }

    @Test (groups = {"wip"})
    void VerifyUploadByClickDragDrop(){
        fileUploaderPage.uploadByClickDragDrop();
        Assert.assertTrue(fileUploaderPage.verifyUpload());
    }

    @Test (groups = {"wip"})
    void VerifyUploadByDragAndDrop(){
        fileUploaderPage.uploadByDragAndDrop();
        Assert.assertTrue(fileUploaderPage.verifyUpload());
    }
    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
