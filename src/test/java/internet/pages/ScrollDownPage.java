package internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import static supports.Browser.visit;

public class ScrollDownPage {
    public void open(String url){
        visit(url);
    }

    public static void scrollDown() throws InterruptedException {
        Actions actions = new Actions(Browser.getDriver());
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0,500).perform();
            Thread.sleep(2000);
        }
    }
}
