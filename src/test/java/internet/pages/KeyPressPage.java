package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;
import static supports.Browser.visit;

public class KeyPressPage {
    public void open(){
     visit("https://the-internet.herokuapp.com/key_presses");
    }
    public void keyControl(){
        Actions actions = new Actions(Browser.getDriver());
        actions.keyDown(Keys.CONTROL).perform();
    }

    public String getResult(){
        return Browser.getText(By.id("result"));
    }
    public void keyA(){
        Actions actions = new Actions(Browser.getDriver());
        actions.keyDown("A").perform();
    }

    public void keyEnter(){
        Actions actions = new Actions(Browser.getDriver());
        actions.keyDown(Keys.ENTER).perform();
    }
}
