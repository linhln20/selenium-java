package bmi.page;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class BodyMassIndexPage {
    private By metricTab = By.id("menuon");
    private By ageTextBox = By.cssSelector("input#cage");
    private By maleRadioButton = By.cssSelector("td label.cbcontainer:first-child");
    private By femaleRadioButton = By.cssSelector("td label.cbcontainer:last-child");
    private By heightTextBox = By.cssSelector("input#cheightmeter");
    private By weightTextBox = By.cssSelector("input#ckg");
    private By calculateButton = By.xpath("//input[@type='submit' and @value='Calculate']");
    private By resultLabel = By.cssSelector(".rightresult .bigtext b");

    public void open() {
//        Browser.clearBrowserCache();
        visit("https://www.calculator.net/bmi-calculator");
    }

    public void selectMetricUnit() { //    Select metric unit tab
        Browser.clickBtn(metricTab);
    }

    public void fillForm(int age, double height, double weight, String gender) {
        Browser.fillInt(ageTextBox,age);

        if (gender.equalsIgnoreCase("male")) {
            Browser.clickBtn(maleRadioButton);
        } else {
            Browser.clickBtn(femaleRadioButton);
        }
        Browser.fillDouble(heightTextBox,height);
        Browser.initializeWait(1);
        Browser.fillDouble(weightTextBox,weight);
    }

    public void clickCalculateBtn() {
        Browser.initializeWait(1);
        Browser.clickBtn(calculateButton);
    }

    public String getResult() {
        Browser.initializeWait(2);
        return Browser.getText(resultLabel);
    }
}
