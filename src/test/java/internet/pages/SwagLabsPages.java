package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class SwagLabsPages {
    public void open(){
        visit("https://www.saucedemo.com");
    }

    public void setUsername(By locator, String username){
        Browser.sentText(locator, username);
    }

    public void setPassword(By locator, String password){
        Browser.sentText(By.id("password"),password);
    }

    public void clickLoginBtn(){
        Browser.click(By.cssSelector("input[type=submit]"));
    }

    public Boolean contains(){
        return Browser.getText(By.xpath("//h3[@data-test='error']")).contains("Epic sadface: Username and password do not match any user in this service");
    }
}
