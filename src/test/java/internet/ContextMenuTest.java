package internet;

import internet.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class ContextMenuTest {
    ContextMenuPage contextMenuPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        contextMenuPage = new ContextMenuPage();
        contextMenuPage.open();
    }

    @Test
    void clickRight(){
        contextMenuPage.clickRight();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }
}
