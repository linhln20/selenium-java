package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import java.awt.*;

import static supports.Browser.visit;

public class TodoMVCPage {
    public void open() {
        visit("https://todomvc.com/examples/react/dist/");
    }

    public void fill(String todoName){
        Browser.clickCheckBox(By.id("todo-input"));
        Browser.fill(By.id("todo-input"), todoName+"\n");
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
        WebElement element = Browser.getElement(By.xpath("//label[@data-testid='todo-item-label']"));
            Browser.hover(element);
        Browser.clickBtn(By.xpath("//button[@data-testid='todo-item-button']"));
        }
    }

//    public boolean isTodoDeleted(){
//        return Browser.getText(By.xpath("//*[@data-testid='todo-item-label']"));
//    }

