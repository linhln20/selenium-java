package internet;

import internet.pages.BasicAuthenticationPage;

import static supports.Browser.visit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static supports.Browser.*;

public class BasicAuthenticationTest {
    BasicAuthenticationPage basicAuthenticationPage;
    @DataProvider
    Object[][] testLogin(){
        return new Object[][]{
                {"Congratulations! You must have the proper credentials","//div[@id='content']//p"},
        };
    }

    @Parameters({"browser","url"})
    @BeforeMethod
    void setup(String browser,String url){
            openBrowser(browser);
            basicAuthenticationPage = new BasicAuthenticationPage();
            visit(url);
    }

    @Test (dataProvider ="testLogin")
     void loginSuccess(String ExpectedMessageContent, String ExpectedMessage){
        Assert.assertTrue(basicAuthenticationPage
            .getMessage(ExpectedMessage)
            .contains(ExpectedMessageContent));
    }

    @AfterMethod
        void tearDown(){
        quit();
    }
}
