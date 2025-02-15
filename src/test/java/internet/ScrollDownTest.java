package internet;

import internet.pages.ScrollDownPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class ScrollDownTest {
    ScrollDownPage scrollDownPage;
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        scrollDownPage = new ScrollDownPage();
        scrollDownPage.open();
    }
    @Test
    void scrollDown() throws InterruptedException {
        scrollDownPage.scrollDown();
    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
