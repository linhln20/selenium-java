package internet;

import internet.pages.BrokenImagesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

import static supports.Browser.openBrowser;
import static supports.Browser.quit;

public class BrokenImagesTest { //chay bang file xml
    BrokenImagesPage brokenImagesPage;

    @DataProvider
    Object[][] verifyBrokenImage(){
        return new Object[][]{
                {"//div/img"},
        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser){
        openBrowser(browser);
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage.open();
    }

    @Test (dataProvider ="verifyBrokenImage")
    void verifyBrokenImage(String locator) {
        Assert.assertTrue(brokenImagesPage
                .isImagesBroken(By.xpath(locator)));
    }

    @AfterMethod
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}