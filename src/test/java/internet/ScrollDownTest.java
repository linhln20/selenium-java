package internet;

import internet.pages.ScrollDownPage;
import org.testng.annotations.Test;
import supports.Browser;

public class ScrollDownTest {
    @Test
    void scrollDown() throws InterruptedException {
        Browser.openBrowser("chrome");
        ScrollDownPage scrollDownPage = new ScrollDownPage();
        scrollDownPage.open();

        scrollDownPage.scrollDown();

        Browser.quit();
    }
}
