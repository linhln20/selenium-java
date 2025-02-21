package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class BodyMassIndexPage {
    private By metricTab = By.cssSelector("li#menuon a");
        private By ageTextBox = By.cssSelector("input#cage");
    private By maleRadioButton = By.cssSelector("td label.cbcontainer:first-child");
    private By femaleRadioButton = By.cssSelector("td label.cbcontainer:last-child");
    private By heightTextBox = By.cssSelector("input#cheightmeter");
    private By weightTextBox = By.cssSelector("input#ckg");
    private By calculateButton = By.xpath("//input[@type='submit' and @value='Calculate']");
    private By resultLabel = By.cssSelector(".rightresult .bigtext b");

    public void open(String url){
        visit(url);
    }

    public void selectMetricUnit(){ //    Select metric unit tab
        Browser.clickBtn(metricTab);
    }

    public void fillForm(int age, double height, double weight, String gender) {
        Browser.fill(ageTextBox, String.valueOf(age));

        if (gender.equalsIgnoreCase("male")) {
            Browser.clickBtn(maleRadioButton);
        } else {
            Browser.clickBtn(femaleRadioButton);
        }
        Browser.fill(heightTextBox, String.valueOf(height));
        Browser.fill(weightTextBox, String.valueOf(weight));
    }

    public void clickCalculateBtn(){
        Browser.clickBtn(calculateButton);
    }

    public String getResult() {
        return Browser.getText(resultLabel);
    }
}
