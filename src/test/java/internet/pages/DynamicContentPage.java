package internet.pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class DynamicContentPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dynamic_content");
    }

    public void loadPage(){
        reloadPage();
    }

    public String getContent(){
       return getElement(By.id("content")).getText();
    }
}
