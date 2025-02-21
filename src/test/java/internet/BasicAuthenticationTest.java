package internet;

import internet.pages.BasicAuthenticationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.maximize;
import static supports.Browser.openBrowser;

public class BasicAuthenticationTest {
    BasicAuthenticationPage basicAuthenticationPage;
    @DataProvider
    public Object[][] loginMessage(){
        return new Object[][]{
            {"Congratulations! You must have the proper credentials."}
        };
    }
    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        maximize();
        basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open(url+"/basic_auth");
    }

    @Test (dataProvider = "loginMessage")
    void loginSuccess(String expectedMessageContent){

        Assert.assertTrue(basicAuthenticationPage
                .getMessage()
                        .contains(expectedMessageContent));
                }

}