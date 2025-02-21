package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import static supports.Browser.visit;

public class HoverPage {
    public void open(String url){
        visit(url);
    }
    private By firstImage = By.xpath("//div[@class='example']/div[1]/img");
    private By firstImageText = By.xpath("//div[@class='example']/div[1]/div/h5");

    public void hoverOverFirstImage() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement image1 = Browser.getElement(firstImage);
        actions.moveToElement(image1).perform();
    }

    public String getFirstImageProfileText() {
        return Browser.getElement(firstImageText).getText();
    }
}
