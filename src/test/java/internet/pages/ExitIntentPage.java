package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import java.awt.*;

import static supports.Browser.getElement;
import static supports.Browser.visit;

public class ExitIntentPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/exit_intent");
    }

    public void moveMouseOutOfScreen() throws AWTException {
        Robot robot = new Robot();
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        robot.mouseMove(screenWidth + 100, 100);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getModal() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ouibounce-modal")));
        return getElement(By.id("ouibounce-modal"));
    }
}
