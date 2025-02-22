package internet;

import internet.pages.KeyPressPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class KeyPressTest {
    KeyPressPage keyPressPage;

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser){
        openBrowser(browser);
        keyPressPage = new KeyPressPage();
        keyPressPage.open();
    }

    @Test
    void keyPress() {
        keyPressPage.keyControl();
        System.out.println(keyPressPage.getResult());

        keyPressPage.keyA();
        System.out.println(keyPressPage.getResult());

        keyPressPage.keyEnter();
        System.out.println(keyPressPage.getResult());
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
