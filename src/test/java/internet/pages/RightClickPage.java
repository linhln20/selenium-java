package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import static supports.Browser.visit;

public class RightClickPage {
    public void open(String url){
        visit(url);
    }

    public void rightClick() {
        Actions actions = new Actions(Browser.getDriver());
        actions.contextClick(Browser.getElement(By.id("hot-spot"))).perform();
    }
}
