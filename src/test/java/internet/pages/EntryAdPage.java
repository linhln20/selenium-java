package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import static supports.Browser.*;

public class EntryAdPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/entry_ad");
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
    }

    public WebElement getModal() {
        return getElement(By.id("modal"));
    }

    public void closeModal(){
        clickBtn(By.xpath("//*[@id='modal']/div[2]/div[3]/p"));
    }

    public boolean isModalClose(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
       return getElement(By.id("modal")).getCssValue("display").equals("none");
    }
}
