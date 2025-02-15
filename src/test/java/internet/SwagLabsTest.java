package internet;

import internet.pages.SwagLabsPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class SwagLabsTest {

    @Test //done
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

//    @Test
//    void authenticationFormTestFailed() {
//        driver.findElement(By.id("user-name")).sendKeys("");
//        driver.findElement(By.id("password")).sendKeys("");
//        driver.findElement(By.cssSelector("input[type=submit]")).click();
//        Assert.assertEquals (driver.getCurrentUrl(), "https://www.saucedemo.com/");
//        String errorMsg = driver.findElement(By.cssSelector("h3 [data-test-error]")).getText();
//        Assert.assertTrue (errorMsg.contains("Epic sadface: Username is required"));
//
//    }
}
