package internet;

import internet.pages.BrokenImagesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
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

    @Parameters({"browser", "url"})
    @BeforeMethod
    void setup(String browser, String url){
        openBrowser(browser);
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage.open(url);
    }

    @Test (dataProvider ="verifyBrokenImage")
    void verifyBrokenImage(String locator) {
        Assert.assertTrue(brokenImagesPage
                .isImagesBroken(By.xpath(locator)));
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}