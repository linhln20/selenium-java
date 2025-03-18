package internet.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static supports.Browser.*;

public class InputsPage {
    public void open(){
    visit("https://the-internet.herokuapp.com/inputs");
    }

    public WebElement getInputField() {
        return getElement(By.cssSelector("input[type='number']"));
    }

    public void sendNumber(int number){
        WebElement inputField = getInputField();
        inputField.clear();
        inputField.sendKeys(String.valueOf(number));
    }

    public void sendText(String text){
        WebElement inputField = getInputField();
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void increaseNumberByKeyboard(){
        getInputField().sendKeys(Keys.ARROW_UP);
    }

    public void decreaseNumberByKeyboard(){
        getInputField().sendKeys(Keys.ARROW_DOWN);
    }

    public String getNumberAfter(){
        return getInputField().getAttribute("value");
    }
}
