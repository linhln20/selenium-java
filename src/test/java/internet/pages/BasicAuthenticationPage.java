package internet.pages;

import org.openqa.selenium.By;

import static supports.Browser.getText;
import static supports.Browser.visit;

public class BasicAuthenticationPage {
    public void open() {
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public String getMessage(String expectedMessageType) {
        return getText(By.xpath(expectedMessageType));
    }
}
