package internet;

import internet.pages.NestedFrameTestPage;
import org.testng.annotations.Test;
import supports.Browser;

public class NestedFrameTest {
    @Test
    void verifyNestedFrameContent(){
        Browser.openBrowser("chrome");
        NestedFrameTestPage nestedFrameTestPage = new NestedFrameTestPage();
        nestedFrameTestPage.open();

        nestedFrameTestPage.swithFame("frame-top");
        nestedFrameTestPage.swithFame("frame-left");

        nestedFrameTestPage.contains("LEFT");

        nestedFrameTestPage.swithParentFame();
        nestedFrameTestPage.swithFame("frame-middle");
        nestedFrameTestPage.contains("MIDDLE");

        nestedFrameTestPage.swithParentFame();
        nestedFrameTestPage.swithFame("frame-right");
        nestedFrameTestPage.contains("RIGHT");

        nestedFrameTestPage.swithToDefaultContent();
        nestedFrameTestPage.swithFame("frame-bottom");
        nestedFrameTestPage.contains("BOTTOM");

        Browser.quit();
    }
}
