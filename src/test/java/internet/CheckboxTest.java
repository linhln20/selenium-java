package internet;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import internet.pages.CheckboxPage;
import supports.Browser;
import static supports.Browser.quit;

public class CheckboxTest {
    CheckboxPage checkboxPage;

    @BeforeMethod
    void setup(){
         Browser.openBrowser("chrome");
         checkboxPage = new CheckboxPage();
         checkboxPage.open();
    }

    @Test
    void verifyAbleSelectCheckboxes(){
        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.check("2");
        Assert.assertTrue(checkboxPage.isCheckboxSelected("2"));
    }

    @Test
    void verifyAbleUnSelectCheckboxes(){
        checkboxPage.uncheck("1");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("1"));

        checkboxPage.uncheck("2");
        Assert.assertFalse(checkboxPage.isCheckboxSelected("2"));
    }

     @AfterMethod
     void tearDown(){
        quit();
     }
}
