package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import java.awt.*;

import static supports.Browser.visit;

public class HorizontalSliderPage {
    private static By sliderValueLocator = By.id("range");

    public void open(String url) {
        visit(url);
    }

    public void getPointer() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement pointer = Browser.getElement(By.xpath("//div[@class='sliderContainer']/input"));
        int width = pointer.getSize().getWidth();
        actions.clickAndHold(pointer).moveByOffset(width, 0).perform();
        Browser.initializeWait(3);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Failed to create Robot instance", e);
        }
        int x = 0;
        int y = width+100;
        robot.mouseMove(x, y);
        Browser.initializeWait(3);
    }

    public static Boolean isSliderSetToValue() {
        Browser.initializeWait(3);
        return Browser.wait.until(ExpectedConditions.textToBe(sliderValueLocator, "5"));
    }
}
