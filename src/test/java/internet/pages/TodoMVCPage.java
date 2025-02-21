package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

import static supports.Browser.visit;

public class TodoMVCPage {
    public void open() {
        visit("https://todomvc.com/examples/react/dist/");
    }

    public void fill(String todoName) {
        Browser.fill(By.className("new-todo"), todoName);
        Browser.pressEnter(By.className("new-todo"));
    }

    public boolean isTaskExit(String taskName){
        List<WebElement> taskList = Browser.getList(By.cssSelector(".todo-list li"));
        return taskList.stream().anyMatch(task -> task.getText().contains(taskName));
    }

    public String getTodoName(String taskName) {
        List<WebElement> taskList = Browser.getList(By.cssSelector(".todo-list li label"));
        for (WebElement task : taskList) {
            if (task.getText().trim().equals(taskName)) {
                return task.getText().trim();
            }
        }
        return null;
    }

    public void markAsCompleted(){
        Browser.clickCheckBox(By.cssSelector(".todo-list li .toggle"));
    }

    public boolean isCompleted(){
        return Browser.isSelected(By.cssSelector(".todo-list li.completed .toggle"));
    }

    public void deleteTodo(){
        WebElement element = Browser.getElement(By.cssSelector(".todo-list li label"));
            Browser.hover(element);
        Browser.clickBtn(By.cssSelector(".todo-list li .destroy"));
        }
    }

