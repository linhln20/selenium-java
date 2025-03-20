package internet.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import supports.Browser;

import java.time.Duration;
import java.util.Set;

import static supports.Browser.clickText;
import static supports.Browser.visit;

public class MultipleWindowsPage {
    public void open() {
    visit("https://the-internet.herokuapp.com/windows");
    }

    public void clickHere() {
    clickText("Click Here");
    }

    public int getWindowHandles() {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindows = Browser.getDriver().getWindowHandles();
        return allWindows.size();
    }
}
