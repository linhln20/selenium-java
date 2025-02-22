package internet;

import internet.pages.BasicAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class BasicAuthenticationTest {
    BasicAuthenticationPage basicAuthenticationPage;
    @DataProvider
    public Object[][] loginMessage(){
        return new Object[][]{
            {"Congratulations! You must have the proper credentials."}
        };
    }
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open();
    }

    @Test (dataProvider = "loginMessage")
    void loginSuccess(String expectedMessageContent){

        Assert.assertTrue(basicAuthenticationPage
                .getMessage()
                        .contains(expectedMessageContent));
                }

}