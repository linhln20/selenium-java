package internet;

import internet.pages.DynamicFormSubmissionPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class DynamicFormSubmissionTest {
    DynamicFormSubmissionPage dynamicFormSubmissionPage;
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        dynamicFormSubmissionPage = new DynamicFormSubmissionPage();
        dynamicFormSubmissionPage.open();
    }

    @Test
    void verifyRemoveACheckBox(){
        dynamicFormSubmissionPage.CheckCheckbox();
        dynamicFormSubmissionPage.clickRemoveButton();
        String message = dynamicFormSubmissionPage.getMessage();

        Assert.assertEquals(message, "It's gone!");
    }

    @Test
    void verifyAddACheckBox(){
        dynamicFormSubmissionPage.CheckCheckbox();
        dynamicFormSubmissionPage.clickRemoveButton();
        dynamicFormSubmissionPage.clickAddButton();

        String message = dynamicFormSubmissionPage.getMessage();

        Assert.assertEquals(message, "It's back!");
    }

    @Test
    void verifyEnableButton(){
        dynamicFormSubmissionPage.clickEnableBtn();
        String message = dynamicFormSubmissionPage.getMessage();

        Assert.assertEquals(message, "It's enabled!");
    }

    @Test
    void verifyDisableButton(){
        dynamicFormSubmissionPage.clickEnableBtn();
        dynamicFormSubmissionPage.clickDisableBtn();
        String message = dynamicFormSubmissionPage.getMessage();


        Assert.assertEquals(message, "It's disabled!");
    }

    @AfterMethod
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
