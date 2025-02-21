package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.visit;

public class NestedFrameTestPage {
    String content = Browser.getText(By.xpath("/html/body"));
    public void open(String url){
        visit(url);
    }

    public void swithFame(String frameName){
        Browser.swithToFrame(frameName);
    }

    public void swithParentFame(){
        Browser.swithParentFrame();
    }

    public void swithToDefaultContent(){
        Browser.swithDefaultContent();
    }
    public String contains(String content){
        content.contains(content);
        return this.content;
    }
}
