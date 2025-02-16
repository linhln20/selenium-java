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

    public void open() {
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void getPointer() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement pointer = Browser.getElement(By.xpath("//div[@class='sliderContainer']/input"));
        int width = pointer.getSize().getWidth();
        actions.clickAndHold(pointer).moveByOffset(width, 0).perform();
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Failed to create Robot instance", e);
        }
        int x = width+200;
        int y = 0;
        robot.mouseMove(x, y);
    }

    public static void waitDuration() {
        Browser.initializeWait(40);
    }

    public static Boolean isSliderSetToValue() {
        return Browser.wait.until(ExpectedConditions.textToBe(sliderValueLocator, "5"));
    }
}
