package internet;

import internet.pages.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static supports.Browser.*;

public class FormAuthenticationTest {
    FormAuthenticationPage formAuthenticationPage;

    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {"tomsmith","SuperSecretPassword!","https://the-internet.herokuapp.com/secure","success","You logged into a secure area!"},
                {"","","https://the-internet.herokuapp.com/login","error","Your username is invalid!"},
                {"tomsmih","SuperSecretPassword!","https://the-internet.herokuapp.com/login","error","Your username is invalid!"},
                {"tomsmith","","https://the-internet.herokuapp.com/login","error","Your password is invalid!"},
                {"tomsmith","SuperSecretPassword","https://the-internet.herokuapp.com/login","error","Your password is invalid!"},
        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser) {
        openBrowser(browser);
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
    }

    @Test(dataProvider = "testData")
    void authenticationFormTest(String username,String password,String expectedUrl,String expectedMessageType,String expectedMessageContent) {
        formAuthenticationPage.login(username, password);

        Assert.assertTrue(formAuthenticationPage
                .getMessage(expectedMessageType)
                .contains(expectedMessageContent));
        Assert.assertEquals(getCurrentUrl(),expectedUrl);
    }

    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}