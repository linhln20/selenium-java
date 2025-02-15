package internet;

import internet.pages.DropDownPage;
import internet.pages.FruitsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import supports.Browser;

public class DropDownTest {
    @BeforeMethod
    public void setUp(){
        Browser.openBrowser("chrome");
    }

    @Test
    void ableToSelectSingleOption() {
        DropDownPage dropDownPage = new DropDownPage();
        dropDownPage.open();

        dropDownPage.select("1");
        Assert.assertTrue(DropDownPage.isOptionSelected("1"));
    }

    @Test(groups = {"wip"})
    void ableSelectMultipleOptions(){
        FruitsPage fruitsPage = new FruitsPage();
        fruitsPage.open();
        FruitsPage.select =  new Select(Browser.getElement(By.id("fruits")));
        Assert.assertTrue(FruitsPage.isMultiple());

        fruitsPage.select("Banana")
                .select("Grape");

        Assert.assertTrue(fruitsPage.isOptionSelected("banana"));
        Assert.assertTrue(fruitsPage.isOptionSelected("grape"));
        Assert.assertFalse(fruitsPage.isOptionSelected("apple"));
        Assert.assertFalse(fruitsPage.isOptionSelected("orange"));

        fruitsPage.deselect("Banana");
        Assert.assertFalse(fruitsPage.isOptionSelected("banana")); // case nay false do khong the select lan nua de deselect
        Assert.assertTrue(fruitsPage.isOptionSelected("grape"));
        Assert.assertFalse(fruitsPage.isOptionSelected("apple"));
        Assert.assertFalse(fruitsPage.isOptionSelected("orange"));

        fruitsPage.deselectAll();
        Assert.assertFalse(fruitsPage.isOptionSelected("banana"));
        Assert.assertFalse(fruitsPage.isOptionSelected("grape"));
        Assert.assertFalse(fruitsPage.isOptionSelected("apple"));
        Assert.assertFalse(fruitsPage.isOptionSelected("orange"));
    }

    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}
