package internet;

import internet.pages.BodyMassIndexPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

import static supports.Browser.openBrowser;
import static supports.Browser.quit;

public class BodyMassIndexTest {
    BodyMassIndexPage bodyMassIndexPage;

    @DataProvider
    Object[][] bmiTestData() {
        return new Object[][]{
                {34, 173, 65, "male"},
                {20, 165, 47, "female"}
        };
    }
    @Parameters({"browser", "url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open(url+"/bmi-calculator");
    }

    @Test (dataProvider = "bmiTestData")
    void verifyBMICalculator(int age, double height, double weight, String gender) {
        bodyMassIndexPage.selectMetricUnit();
        bodyMassIndexPage.fillForm(age, height,weight,gender);
        bodyMassIndexPage.clickCalculateBtn();

        String bmiResult = CalculateBMI.calculateBmi(height, weight);
        String actualResult = bodyMassIndexPage.getResult();
        Assert.assertTrue(actualResult.contains(bmiResult));
    }

    @AfterMethod
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        quit();
    }
}
