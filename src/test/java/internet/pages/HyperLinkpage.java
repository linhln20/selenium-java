package internet.pages;

import supports.Browser;

import static supports.Browser.visit;

public class HyperLinkpage {
    public void open(){
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickLink(String text){
        Browser.clickText(text);
    }

}
