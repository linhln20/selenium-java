package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class ShiftingContentPage {
    public void open() {
    visit("https://the-internet.herokuapp.com/shifting_content");
    }

    public void clickExample1() {
    clickText("Example 1: Menu Element");
    }


    public Object getElementLocation() {
        WebElement element = getElement(By.xpath("//*[@id='content']/div/ul/li[4]/a"));
        return element.getSize();
    }

    public void clickModeRandom() {
        click(By.xpath("//*[@id='content']/div/p[2]/a"));
    }

    public void clickExample2() {
        clickText("Example 2: An image");
    }

    public void clickExample3() {
        clickText("Example 3: List");
    }

}
