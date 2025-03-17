package internet;

import internet.pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static supports.Browser.*;

public class ForgotPasswordTest {
    ForgotPasswordPage forgotPasswordPage;

    @DataProvider
    Object [][] testData() {
        return new Object[][] {
                {"ngoclinhlam95@gmail.com", "Internal Server Error"},
                {"tomsmith", "Internal Server Error"},
                {"@", "Internal Server Error"},
                {"╰(*°▽°*)╯", "Internal Server Error"},
                {"", "Internal Server Error"},
            {"abc@email.com", "Internal Server Error"},
                {"abc@emailcom", "Internal Server Error"},
                {"@email.com", "Internal Server Error"},
                {"1'", "Internal Server Error"},
                {"1=1", "Internal Server Error"}
        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser) {
        openBrowser(browser);
        forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.open();
    }

    @Test (dataProvider = "testData")
    void forgotPasswordTest(String email, String expectedMessage) {
        forgotPasswordPage.retrievePassword(email);
        Assert.assertTrue(forgotPasswordPage.getMessage().contains(expectedMessage));
    }

    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}
