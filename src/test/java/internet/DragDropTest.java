package internet;

import internet.pages.DragDropElementsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class DragDropTest {
    DragDropElementsPage dragDropElementsPage;
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        dragDropElementsPage = new DragDropElementsPage();
        dragDropElementsPage.open();
    }
    @Test
    void dragDropElements(){
        dragDropElementsPage.dragDrop();

        Assert.assertEquals(dragDropElementsPage.getSource(),"A");
        Assert.assertEquals(dragDropElementsPage.getTarget(),"B");

        dragDropElementsPage.dragAndDrop();

        Assert.assertEquals(dragDropElementsPage.getSource(),"B");
        Assert.assertEquals(dragDropElementsPage.getTarget(),"A");
    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
