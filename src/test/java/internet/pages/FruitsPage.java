package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class FruitsPage {
    public static Select select;
    public FruitsPage(){
    }

    public void open(){
        Browser.visit("https://output.jsbin.com/osebed/2");
    }

    public FruitsPage select(String option){
        select.selectByVisibleText(option);
        return this;
        }

    public FruitsPage  deselect(String option){
        Actions actions = new Actions(Browser.getDriver());
        WebElement element = Browser.getElement(By.cssSelector(String.format("option[value='%s']", option.toLowerCase())));
        actions.keyDown(Keys.CONTROL)
                .click(element)
                .keyUp(Keys.CONTROL)
                .perform();
        return this;
    }

    public void deselectAll (){
        select.deselectAll();
    }

    public static boolean isOptionSelected(String option){
        String locatorDropdown = String.format("option[value='%s']",option);
        return Browser.isSelected(By.cssSelector(locatorDropdown));
    }

    public static boolean isMultiple(){
        return select.isMultiple();
    }
}
