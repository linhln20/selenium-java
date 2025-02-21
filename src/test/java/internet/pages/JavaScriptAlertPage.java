package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class JavaScriptAlertPage {
    public void open(String url){
        visit(url);
    }
    public void clickAlertBtn(String visibleText){
        Browser.click(By.xpath(String.format("//button[.='Click for JS %s']", visibleText)));
    }

    public String getResult(){
        return Browser.getText(By.id("result"));
    }

    public void sentKey(String text){
        Browser.sentKey(text);
    }
}
