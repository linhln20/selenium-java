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
    @Parameters({"browser","url"})
    @BeforeMethod
    void setup(String browser, String url) {
        openBrowser(browser);
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open(url+"/login");
    }

    @Test(dataProvider = "testData")
    void authenticationFormTest(String username,String password,String expectedUrl,String expectedMessageType,String expectedMessageContent) {
        formAuthenticationPage.login(username, password);

        Assert.assertEquals(getCurrentUrl(),expectedUrl);
        Assert.assertTrue(formAuthenticationPage
                .getMessage(expectedMessageType)
                .contains(expectedMessageContent));
//      Assert.assertTrue(driver.findElement(By.className(expectedMessageType)).getText().contains(expectedMessageContent));

    }
    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}