package internet;

import internet.pages.BodyMassIndexPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class BodyMassIndexTest {
    BodyMassIndexPage bodyMassIndexPage;

    @BeforeMethod
    void setUp(){
        Browser.openBrowser("chrome");
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @Test
    void verifyBMICalculator() {
        bodyMassIndexPage.selectMetricUnit();
        int age = 34;
        String gender = "male";
        double height = 173.0;
        double weight = 65.0;

        bodyMassIndexPage.fillAge(age);
        bodyMassIndexPage.selectGender(gender);
        bodyMassIndexPage.fillHeight(height);
        bodyMassIndexPage.fillWeight(weight);
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
        Browser.quit();
    }
}
