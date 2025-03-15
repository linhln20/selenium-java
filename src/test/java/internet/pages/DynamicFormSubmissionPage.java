package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import static supports.Browser.*;

public class DynamicFormSubmissionPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public void CheckCheckbox(){
        clickCheckBox(By.id("checkbox"));
    }

    public void clickRemoveButton(){
        clickBtn(By.xpath("//button[@type='button']"));
    }

    public void clickAddButton(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        clickBtn(By.cssSelector("#checkbox-example > button"));
    }

    public String getMessage() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        return Browser.getElement(By.id("message")).getText();
    }

    public void clickEnableBtn(){
    clickBtn(By.cssSelector("#input-example > button"));
    }

    public void clickDisableBtn(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        clickBtn(By.cssSelector("#input-example > button"));
    }

}
