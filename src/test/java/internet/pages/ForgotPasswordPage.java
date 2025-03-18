package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static supports.Browser.*;

public class ForgotPasswordPage {
    private By emailTxt = By.id("email");
    private By retrieveBtn = By.id("form_submit");

    public void open() {
    visit("https://the-internet.herokuapp.com/forgot_password");
    }

public void retrievePassword(String email) {
    fill(emailTxt);
    clickBtn(retrieveBtn);
    }

    public String getMessage() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > h1")));
    return getText(By.cssSelector("body > h1"));
    }
}
