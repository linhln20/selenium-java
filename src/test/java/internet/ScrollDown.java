package internet;

import internet.pages.ScrollDownPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import supports.Browser;

public class ScrollDown {
    @Test
    void scrollDown() throws InterruptedException {
        Browser.openBrowser("chrome");
        ScrollDownPage scrollDownPage = new ScrollDownPage();
        scrollDownPage.open();

        scrollDownPage.scrollDown();

        Browser.quit();
    }
}
