package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import java.awt.*;

import static supports.Browser.visit;

public class TodoMVCPage {
    public void open() {
        visit("https://todomvc.com/examples/react/dist/");
    }

    public void click(By locator){
        Browser.clickCheckBox(locator);
    }

    public void type(By locator, String todoName){
        Browser.sentText(locator, todoName);
        Browser.pressEnter(locator);
    }

    public String getTodoName(){
         return Browser.getText(By.xpath("//*[@data-testid='todo-item-label']"));
    }

    public void markAsCompleted(){
        Browser.clickCheckBox(By.xpath("//input[@data-testid='todo-item-toggle']"));
    }

    public boolean isCompleted(){
        return Browser.isSelected(By.xpath("//input[@data-testid='todo-item-toggle']"));
    }

    public void moveMouse(){
        WebElement pointer = Browser.getElement(By.xpath("//label[@data-testid='todo-item-label']"));
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Failed to create Robot instance", e);
        }
        int x = pointer.getLocation().getX();
        int y = pointer.getLocation().getY();
        System.out.println(x+" "+y);
        robot.mouseMove(x, y);
    }
    public void deleteTodo(){
        Browser.clickBtn(By.xpath("//button[@data-testid='todo-item-button']"));
    }

//    public boolean isTodoDeleted(){
//        return Browser.getText(By.xpath("//*[@data-testid='todo-item-label']"));
//    }
}
