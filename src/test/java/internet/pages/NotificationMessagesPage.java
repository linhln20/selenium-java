package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static supports.Browser.*;

public class NotificationMessagesPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/notification_message_rendered");
    }

    public void clickHere() {
        reloadPage();
        clickText("Click here");
    }

    public String getNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return getText(By.id("flash"));
    }
}
