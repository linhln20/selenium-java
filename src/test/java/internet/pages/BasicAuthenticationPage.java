package internet.pages;

import org.openqa.selenium.By;
import static supports.Browser.getText;
import static supports.Browser.visit;

public class BasicAuthenticationPage {
    public void open(String url){
        visit(url);
    }
    public String getMessage(String ExpectedMessage){
        return getText(By.xpath(ExpectedMessage));
    }
    public boolean isMessageContains(String expectedMessage, String expectedMessageContent){
        return getMessage(expectedMessage).contains(expectedMessageContent);
    }
}
