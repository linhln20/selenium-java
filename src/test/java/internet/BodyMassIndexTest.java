package internet;

import internet.pages.BodyMassIndexPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import supports.Browser;

public class BodyMassIndexTest {
    BodyMassIndexPage bodyMassIndexPage;

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {34, "male", 173, 65},
                {20, "female", 165, 47}
        };
    }

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @Test(dataProvider = "testData")//, groups = {"wip"}
    void verifyBMICalculator(int age, String gender, int height, int weight) {
        bodyMassIndexPage.selectMetricUnit();
        bodyMassIndexPage.fillAge(age);
        bodyMassIndexPage.selectGender(gender);
        bodyMassIndexPage.fillHeight(height);
        bodyMassIndexPage.fillWeight(weight);
        bodyMassIndexPage.clickCalculateBtn();

        String BmiResult = CalculateBMI.calculateBmi(height, weight);
        String actualResult = bodyMassIndexPage.getResult();
        Assert.assertTrue(actualResult.contains(BmiResult));
    }

    @AfterMethod
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
