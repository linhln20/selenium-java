package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import static supports.Browser.*;


public class FormAuthenticationPage {
    private By usernameTxt=By.id("username");
    private By passwordTxt=By.id("password");
    private By loginBtn=By.cssSelector("button[type=submit]");

    public void open(){
    visit("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password){
        fill(usernameTxt);
        fill(passwordTxt);
        click(loginBtn);
    }

    public String getMessage(String expectedMessageType){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        return getText(By.className(expectedMessageType));
        }
    }

