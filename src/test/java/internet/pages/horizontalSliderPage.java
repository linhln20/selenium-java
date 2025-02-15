package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Browser;

import static supports.Browser.visit;

public class HorizontalSliderPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void getPointer(){
        Actions actions = new Actions(Browser.getDriver());

        WebElement pointer = Browser.getElement(By.xpath("//div[@class='sliderContainer']/input"));
        int width = pointer.getSize().getWidth();
        actions.clickAndHold(pointer).moveByOffset(width,0).perform();
    }

//        private static Duration waitDuration = Duration.ofSeconds(60);
        private static By sliderValueLocator = By.id("range");
        public static void waitDuration(){
            Browser.initializeWait(60);
        }
        public static Boolean isSliderSetToValue() {
            return Browser.wait.until(ExpectedConditions.textToBe(sliderValueLocator,"5"));
        }
    }
