package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.*;

public class DisappearingElementsPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/disappearing_elements");
    }

    public void clickHome(){
        clickText("Home");
    }

    public void clickAbout(){
        clickText("About");
    }

    public void clickPortfolio(){
        clickText("Portfolio");
    }

    public void clickGallery(){
        clickText("Gallery");
    }

    public String getCurrentUrl(){
        return Browser.getCurrentUrl();
    }

    public void clickContactUs(){
        clickText("Contact Us");
    }
    public void getContent(){
        getText(By.cssSelector("body > h1"));
    }
}
