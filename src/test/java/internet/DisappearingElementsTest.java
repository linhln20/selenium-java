package internet;

import internet.pages.DisappearingElementsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.openBrowser;

public class DisappearingElementsTest {
    DisappearingElementsPage disappearingElementsPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        disappearingElementsPage = new DisappearingElementsPage();
        disappearingElementsPage.open();
    }

    @Test
    void clickHome() {
        disappearingElementsPage.clickHome();
        Assert.assertEquals(disappearingElementsPage.getCurrentUrl(), "https://the-internet.herokuapp.com/");
    }

    @Test
    void clickAbout() {
        disappearingElementsPage.clickAbout();
        Assert.assertEquals(disappearingElementsPage.getCurrentUrl(), "https://the-internet.herokuapp.com/about/");
    }

    @Test
    void clickContactUs() {
        disappearingElementsPage.clickContactUs();
        Assert.assertEquals(disappearingElementsPage.getCurrentUrl(), "https://the-internet.herokuapp.com/contact-us/");
    }

    @Test
    void clickPortfolio() {
        disappearingElementsPage.clickPortfolio();
        Assert.assertEquals(disappearingElementsPage.getCurrentUrl(), "https://the-internet.herokuapp.com/portfolio/");
    }

    @Test
    void clickGallery() {
        disappearingElementsPage.clickGallery();
        Assert.assertEquals(disappearingElementsPage.getCurrentUrl(), "https://the-internet.herokuapp.com/gallery/");
    }
}
