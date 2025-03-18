package internet;

import internet.pages.InputsPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static supports.Browser.*;

public class InputsTest {
    InputsPage inputsPage;

    @DataProvider
    Object [][] testText() {
        return new Object[][] {
                {"abc", ""},
                {"1a", "1"},
                {"@", ""},
                {"╰(*°▽°*)╯", ""},
                {"1╰(*°2▽°*)╯,", "12"},
                {"1=1", "11"}

        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser) {
        openBrowser(browser);
        inputsPage = new InputsPage();
        inputsPage.open();
    }

    @Test
    void verifyIncreaseNumberByKeyboard() {
        inputsPage.sendNumber(5);
        inputsPage.increaseNumberByKeyboard();
        int actualValue = Integer.parseInt(inputsPage.getNumberAfter());
        Assert.assertEquals(actualValue, 6);
    }

    @Test
    void verifyDecreaseNumberByKeyboard() {
        inputsPage.sendNumber(5);
        inputsPage.decreaseNumberByKeyboard();
        int actualValue = Integer.parseInt(inputsPage.getNumberAfter());
        Assert.assertEquals(actualValue, 4);
    }

    @Test (dataProvider = "testText")
    void verifyInvalidNumber(String text, String expectedResult) {
        inputsPage.sendText(text);
        Assert.assertEquals(inputsPage.getNumberAfter(), expectedResult);
    }

    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}
