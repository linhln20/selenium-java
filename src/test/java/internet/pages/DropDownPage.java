package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

import static supports.Browser.visit;

public class DropDownPage {
    public void open(String url){
        visit(url);
    }

    public void select(String option){
        Select select = new Select(Browser.getElement(By.id("dropdown")));
        select.selectByValue(option);
    }
    public static boolean isOptionSelected(String option){
        String locatorDropdown = String.format("option[value='%s']",option);
        return Browser.isSelected(By.cssSelector(locatorDropdown));
    }
}
