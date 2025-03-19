package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import supports.Browser;

import static supports.Browser.*;

public class LargeDomPage {
        public void open() {
        visit("https://the-internet.herokuapp.com/large");
    }

    public int getAllNodes() {
        WebElement container = Browser.getDriver().findElement(By.id("sibling-1.1"));
        return container.findElements(By.tagName("div")).size();
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isAtBottom() {
//        Browser.reloadPage();
        return (Boolean) ((JavascriptExecutor) Browser.getDriver()).executeScript(
                "return window.innerHeight + window.scrollY >= document.body.scrollHeight;"
        );
    }

    public boolean isSpecificNodeVisible() {
        WebElement specificNode = getElement(By.xpath("//tr[10]/td[10]"));
        return specificNode.isDisplayed();
    }

    public long getPageLoadTime() {
        long start = System.currentTimeMillis();
        Browser.reloadPage();
        return System.currentTimeMillis() - start;
    }

    public boolean isElementClickable() {
        WebElement element = getElement(By.xpath("//tr[5]/td[5]"));
        return element.isEnabled();
    }

    public boolean hasHorizontalScroll() {
        return (Boolean) ((JavascriptExecutor) Browser.getDriver()).executeScript(
                "return document.body.scrollWidth > window.innerWidth;"
        );
    }

    public WebElement isElementFoundByXPath() {
        return getElement(By.xpath("//*[@id='content']"));
    }

    public boolean isAtTop() {
        return (Boolean) ((JavascriptExecutor) Browser.getDriver()).executeScript("return window.scrollY == 0;");
    }

    public void resizeWindow(int width, int height) {
        Browser.getDriver().manage().window().fullscreen();
        Browser.getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
    }

    public boolean isResponsive() {
        return Browser.getDriver().manage().window().getSize().getHeight() <= 600;
    }

    public void addAndRemoveNode() {
        ((JavascriptExecutor) Browser.getDriver()).executeScript(
                "let elem = document.createElement('div'); " +
                        "elem.id = 'temp-node'; " +
                        "document.body.appendChild(elem); " +
                        "elem.remove();"
        );
    }
}


