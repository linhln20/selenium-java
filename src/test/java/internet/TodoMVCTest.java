package internet;

import internet.pages.TodoMVCPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class TodoMVCTest {
    TodoMVCPage todoMVCPage;

    @BeforeMethod
    void setUp(){
        Browser.openBrowser("chrome");
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
//        Browser.maximize();
    }

    @Test
    void createNewTodo(){
        todoMVCPage.click(By.id("todo-input"));
        todoMVCPage.type(By.id("todo-input"),"Create a todo ticket");

        Assert.assertEquals(todoMVCPage.getTodoName(),"Create a todo ticket");
    }

    @Test
    void markCompleteTodo(){
        todoMVCPage.click(By.id("todo-input"));
        todoMVCPage.type(By.id("todo-input"),"Create a todo ticket");
        todoMVCPage.markAsCompleted();

        Assert.assertTrue(todoMVCPage.isCompleted());
    }

    @Test (groups = {"wip"})
    void verifyUserAbleDeleteATodo(){
        todoMVCPage.click(By.id("todo-input"));
        todoMVCPage.type(By.id("todo-input"),"Create a todo ticket");
        todoMVCPage.moveMouse();

        todoMVCPage.deleteTodo();
        Assert.assertNotEquals(todoMVCPage.getTodoName(),"Create a todo ticket");
    }

//    @AfterMethod
//    void tearDown(){
//        Browser.quit();
//    }
}
