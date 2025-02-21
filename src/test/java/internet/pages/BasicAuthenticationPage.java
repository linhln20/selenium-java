package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.getText;
import static supports.Browser.visit;

public class BasicAuthenticationPage {
    public void open(String url) {
        visit(url);
    }

    public String getMessage() {
        return getText(By.id("content"));
    }
}
