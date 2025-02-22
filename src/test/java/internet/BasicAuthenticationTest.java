package internet;

import internet.pages.BasicAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class BasicAuthenticationTest {
    BasicAuthenticationPage basicAuthenticationPage;
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open();
    }

    @Test
    void loginSuccess(){

        Assert.assertTrue(basicAuthenticationPage
                .getMessage()
                        .contains("Congratulations! You must have the proper credentials."));
                }

}