package internet.pages;

import org.openqa.selenium.By;
import static supports.Browser.*;

public class CheckboxPage {

    public void open(String url){
        visit(url);
    }

    private By getCheckbox(String checkboxName){
        String checkboxLocator = String.format("//form[@id='checkboxes']/input[%s]",checkboxName);
        return By.xpath(checkboxLocator);
    }

    public void check (String checkboxName){
        if(!isCheckboxSelected(checkboxName)){
            click(getCheckbox(checkboxName));
        }
    }

    public void uncheck (String checkboxName){
        if(isCheckboxSelected(checkboxName)){
            click(getCheckbox(checkboxName));
        }
    }

    public boolean isCheckboxSelected(String checkboxName){
        return isSelected(getCheckbox(checkboxName));
    }
}
