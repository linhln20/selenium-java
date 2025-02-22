package internet;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import internet.pages.CheckboxPage;
import supports.Browser;

import static supports.Browser.openBrowser;

public class CheckboxTest {
    CheckboxPage checkboxPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
         checkboxPage = new CheckboxPage();
         checkboxPage.open();
    }

    @Test
    void verifyAbleSelectCheckboxes(){
        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.check("2");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("2"));
    }

    @Test
    void verifyAbleUnSelectCheckboxes(){
        checkboxPage.uncheck("1");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.uncheck("2");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("2"));
    }

     @AfterMethod
     void tearDown(ITestResult testResult){
         if(testResult.isSuccess()){
             Browser.captureScreen(testResult.getName());
         }
         Browser.quit();
     }
}
