package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supports.Browser;

import java.awt.*;
import java.time.Duration;

import static supports.Browser.visit;

public class HorizontalSliderPage {
    private static By sliderValueLocator = By.id("range");

    public void open(String url) {
        visit(url);
    }

    public void getPointer() {
        Actions actions = new Actions(Browser.getDriver());
        WebElement pointer = Browser.getElement(By.xpath("//div[@class='sliderContainer']/input"));
        WebElement nextPoint = Browser.getElement(By.cssSelector(".example h3"));
        int width = pointer.getSize().getWidth();
        actions.clickAndHold(pointer).moveByOffset(width, 0).perform();
        Browser.initializeWait(3);
        actions.moveToElement(nextPoint).perform();
    }

    public boolean isSliderSetToValue() {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(3));
        try {
            return wait.until(ExpectedConditions.textToBe(sliderValueLocator, "5"));
        } catch (Exception e) {
            return false;
        }
    }
}
