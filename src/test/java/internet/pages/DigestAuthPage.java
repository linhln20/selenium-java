package internet.pages;

import org.openqa.selenium.By;

import static supports.Browser.getText;
import static supports.Browser.visit;

public class DigestAuthPage {
public void open(){
    visit("https://admin:admin@the-internet.herokuapp.com/digest_auth");
}

    public String getMessage() {
        return getText(By.cssSelector("#content > div > p"));
    }
}
