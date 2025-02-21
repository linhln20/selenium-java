package internet.pages;

import org.openqa.selenium.By;

import static supports.Browser.getText;
import static supports.Browser.visit;

public class BasicAuthenticationPage {
    public void open(String url) {
        visit(url);
    }

    public String getMessage(String expectedMessageType) {
        return getText(By.xpath(expectedMessageType));
    }
}
