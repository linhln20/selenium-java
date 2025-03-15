package internet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import static supports.Browser.getElement;
import static supports.Browser.visit;

public class ContextMenuPage {

    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void clickRight(){
        WebElement target = getElement(By.id("hot-spot"));
        Actions actions = new Actions(Browser.getDriver());
        actions.contextClick(target).perform();
    }

    public String getAlertText(){
        Alert alert = Browser.getDriver().switchTo().alert();
        return alert.getText();
    }
}
