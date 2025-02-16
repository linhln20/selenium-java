package internet;

import internet.pages.BasicAuthenticationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import supports.Browser;

public class BasicAuthenticationTest {
    BasicAuthenticationPage basicAuthenticationPage;
    @DataProvider
    public Object[][] loginMessage(){
        return new Object[][]{
            {"Congratulations! You must have the proper credentials.", "//div[@id='content']//p"}
        };
    }
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open();
    }

    @Test (dataProvider = "loginMessage")
    void loginSuccess(String expectedMessageContent, String expectedMessageType ){
        Assert.assertTrue(basicAuthenticationPage
                .getMessage(expectedMessageType)
                        .contains(expectedMessageContent));
                }

}