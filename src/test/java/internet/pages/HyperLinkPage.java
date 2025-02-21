package internet.pages;

import supports.Browser;

import static supports.Browser.visit;

public class HyperLinkPage {
    public void open(String url){
        visit(url);
    }

    public void clickLink(String text){
        Browser.clickText(text);
    }

}
