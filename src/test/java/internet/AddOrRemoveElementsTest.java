package internet;

import internet.pages.AddOrRemoveElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class AddOrRemoveElementsTest {
AddOrRemoveElementsPage addOrRemoveElementsPage;
    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        addOrRemoveElementsPage = new AddOrRemoveElementsPage();
        addOrRemoveElementsPage.open();
    }

    @Test
    void verifyAddElement(){
        addOrRemoveElementsPage.clickAddElementBtn();

        int currentElementSize = addOrRemoveElementsPage.getSize();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elements")));
        Assert.assertEquals(currentElementSize,1);
    }

    @Test
    void verifyRemoveElements(){
        addOrRemoveElementsPage.clickAddElementBtn();
        addOrRemoveElementsPage.clickAddElementBtn();
        addOrRemoveElementsPage.clickAddElementBtn();
        int elementSizeBefore = addOrRemoveElementsPage.getSize();
        System.out.println(elementSizeBefore);

        addOrRemoveElementsPage.clickRemoveElementBtn();
//        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elements")));
        int currentElementSize = addOrRemoveElementsPage.getSize();
        System.out.println(currentElementSize);


        Assert.assertEquals(elementSizeBefore - currentElementSize,1);
    }

}
