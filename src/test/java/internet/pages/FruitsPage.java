package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class FruitsPage {
    public static Select select;
    public FruitsPage(){
//        select = new Select(Browser.getElement(By.id("fruits")));
    }
    public void open(){
        Browser.visit("https://output.jsbin.com/osebed/2");
    }
    public FruitsPage select(String option){
        select.selectByVisibleText(option);
        return this;
        }

    public FruitsPage  deselect(String option){
        select.selectByVisibleText(option);
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
