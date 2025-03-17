package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class FloatingMenuPage {
    private JavascriptExecutor js;
    public void open(){
        visit("http://the-internet.herokuapp.com/floating_menu");
    }

    public WebElement getFloatingMenu(){
        WebElement floatingMenu = getElement(By.id("menu"));
        return floatingMenu;
    }

    public void scroll(){
        js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
