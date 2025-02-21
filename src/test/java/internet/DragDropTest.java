package internet;

import internet.pages.DragDropElementsPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class DragDropTest {
    DragDropElementsPage dragDropElementsPage;

    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        dragDropElementsPage = new DragDropElementsPage();
        dragDropElementsPage.open(url+"/drag_and_drop");
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
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
