package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class BodyMassIndexPage {
    public void open(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricUnit(){ //    Select metric unit tab
        Browser.clickBtn(By.id("menuon"));
    }

    public void fillAge(int age){
        Browser.fillInt(By.id("cage"), age);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            Browser.getElement(By.xpath("//label[@for='csex1']")).click(); // Chọn Male
        } else if (gender.equalsIgnoreCase("female")) {
            Browser.getElement(By.xpath("//label[@for='csex2']")).click(); // Chọn Female
        } else {
            throw new IllegalArgumentException("Giới tính không hợp lệ! Chỉ chấp nhận 'male' hoặc 'female'.");
        }
    }

    public void fillWeight(double weight){
        Browser.fillDouble(By.id("ckg"), weight);
    }

    public void fillHeight(double height){
        Browser.fillDouble(By.id("cheightmeter"), height);
    }

    public void clickCalculateBtn(){
        Browser.clickBtn(By.xpath("//input[@type='submit']"));
    }

    public String getResult() {
        return Browser.getText(By.cssSelector(".rightresult .bigtext b"));
    }
}
