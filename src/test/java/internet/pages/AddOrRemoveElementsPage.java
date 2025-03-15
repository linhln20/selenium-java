package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

import static supports.Browser.*;

public class AddOrRemoveElementsPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAddElementBtn(){
        clickBtn(By.xpath("//button[@onclick='addElement()']"));
        initializeWait(2);
    }
    public void clickRemoveElementBtn(){
        clickBtn(By.cssSelector("#elements > button:nth-child(1)"));
    }
    public int getSize(){
        return Browser.getSize(By.xpath("//*[@id='elements']/button"));
    }

}
