package internet;

import internet.pages.dragDropElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

public class dragDropElements {
    @Test
    void dragDropElements(){ //done
        Browser.openBrowser("chrome");
        dragDropElementsPage dragDropElementsPage = new dragDropElementsPage();
        dragDropElementsPage.open();

        dragDropElementsPage.dragDrop();

        Assert.assertEquals(dragDropElementsPage.getSource(),"A");
        Assert.assertEquals(dragDropElementsPage.getTarget(),"B");

        dragDropElementsPage.dragAndDrop();

        Assert.assertEquals(dragDropElementsPage.getSource(),"B");
        Assert.assertEquals(dragDropElementsPage.getTarget(),"A");

        Browser.quit();
    }
}
