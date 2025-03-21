package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class ShadowDOMPage {
    public void open() {
    visit("https://the-internet.herokuapp.com/shadowdom");
    }

    public String getShadowDOMText() {
        WebElement shadowHost = getElement(By.tagName("my-paragraph"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        WebElement shadowContent = shadowRoot.findElement(By.xpath("//*[@id='content']/my-paragraph[1]"));
        return shadowContent.getText();
    }
}
