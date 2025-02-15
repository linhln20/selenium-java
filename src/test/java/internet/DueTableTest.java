package internet;

import internet.pages.WebTablePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

import java.util.List;

public class DueTableTest {
    WebTablePage webTablePage;

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("Chrome");
        webTablePage = new WebTablePage();
        webTablePage.open();
    }

    @Test
    void verifyMaxDuePerson() {
        Assert.assertEquals(webTablePage.getMaxDuePerson(), "Doe Jason");
    }


    @Test
    void verifyMinimumDueValuePerson() {

        Assert.assertEquals(webTablePage.getMinDuePerson(), List.of("Smith John", "Conway Tim"));
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
