package internet;

import internet.pages.RightClickPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import supports.Browser;

public class RightClickTest {
    @Test
    void rightClick(){
        Browser.openBrowser("chrome");
        RightClickPage rightClickPage = new RightClickPage();
        rightClickPage.open();

        rightClickPage.rightClick();
        Browser.acceptAlert();
        Browser.quit();
    }
}
