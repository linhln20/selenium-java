package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;
import static supports.Browser.visit;

public class DynamicLoadingPage {
    private static By goal = By.id("finish");
    public void openExp1(){
       visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void openExp2(){
        visit("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public void click(){
        Browser.clickBtn(By.xpath("//button[.='Start']"));
    }

    public WebElement waitLoad(){
        Browser.initializeWait(20);
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(goal));
    }

    public Boolean waitLoadB(){
        Browser.initializeWait(20);
        return Browser.wait.until(d -> Browser.getElement(goal).isDisplayed());
    }

    public String getText(){
        return Browser.getText(goal);
    }
}
