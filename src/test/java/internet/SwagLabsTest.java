package internet;

import internet.pages.SwagLabsPages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class SwagLabsTest {

    @Test
    void errorWithInvalidUsername(){
        Browser.openBrowser("chrome");
        SwagLabsPages swagLabsPages = new SwagLabsPages();
        swagLabsPages.open();

        swagLabsPages.setUsername(By.id("user-name"),"standarduser");
        swagLabsPages.setPassword(By.id("password"),"secret_sauce");
        swagLabsPages.clickLoginBtn();
        Assert.assertEquals(Browser.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(swagLabsPages.contains());

        Browser.quit();
        }
}
