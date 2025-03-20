package internet;

import internet.pages.LargeDomPage;
import org.testng.Assert;
import org.testng.annotations.*;
import supports.Browser;

public class LargeDomTest {
    LargeDomPage largeDomPage;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        Browser.openBrowser(browser);
        largeDomPage = new LargeDomPage();
        largeDomPage.open();
    }

    @Test //(groups = {"wip"})
    void verifyLargeDom() {
        Assert.assertEquals(largeDomPage.getAllNodes(), 149);
    }

    @Test (groups = {"wip"})
    public void testScrollToBottom() {
        largeDomPage.scrollToBottom();
        Assert.assertTrue(largeDomPage.isAtBottom(), "Failed to scroll to the bottom!");
    }

    @Test //(groups = {"wip"})
    public void testSpecificNodeVisible() {
        Assert.assertTrue(largeDomPage.isSpecificNodeVisible(), "Specific node not visible!");
    }

    @Test //(groups = {"wip"})
    public void testPageLoadTime() {
        Assert.assertTrue(largeDomPage.getPageLoadTime() < 5000, "Page load time is too long!");
    }

    @Test //(groups = {"wip"})
    public void testElementClickable() {
        Assert.assertTrue(largeDomPage.isElementClickable(), "Element is not clickable!");
    }

    @Test //(groups = {"wip"})
    public void testHorizontalScroll() {
        Assert.assertTrue(largeDomPage.hasHorizontalScroll(), "No horizontal scroll detected!");
    }

    @Test //(groups = {"wip"})
    public void testElementByXPath() {
        Assert.assertTrue(largeDomPage.isElementFoundByXPath().isDisplayed());
    }

    @Test (groups = {"wip"})
    public void testReloadAndScroll() {
        largeDomPage.scrollToBottom();
        Browser.getDriver().navigate().refresh();
        Assert.assertTrue(largeDomPage.isAtTop(), "Page is not scrolled to top after reload!");
    }

    @Test (groups = {"wip"})
    public void testResponsiveDisplay() {
        largeDomPage.resizeWindow(800, 600);
        Assert.assertTrue(largeDomPage.isResponsive(), "Page is not responsive!");
//        largeDomPage.resizeWindow(1920, 1080);
    }

    @Test
    public void testDomManipulationPerformance() {
        long before = System.currentTimeMillis();
        largeDomPage.addAndRemoveNode();
        long after = System.currentTimeMillis();
        Assert.assertTrue((after - before) < 2000, "DOM manipulation is too slow!");
    }
}
