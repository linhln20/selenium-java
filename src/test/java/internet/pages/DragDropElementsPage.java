package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import static supports.Browser.visit;

public class DragDropElementsPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragDrop(){
        Actions actions = new Actions(Browser.getDriver());
    }

    public String getSource(){
        return Browser.getText(By.xpath("//div[@id='column-a']/header"));
    }

    public String getTarget(){
        return Browser.getText(By.xpath("//div[@id='column-b']/header"));
    }

    public void dragAndDrop(){
        Actions actions = new Actions(Browser.getDriver());
        WebElement sourceElement = Browser.getElement(By.id("column-a"));
        WebElement targetElement = Browser.getElement(By.id("column-b"));
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }
}
