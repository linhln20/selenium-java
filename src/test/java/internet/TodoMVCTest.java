package internet;

import internet.pages.TodoMVCPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class TodoMVCTest {
    TodoMVCPage todoMVCPage;
    String taskName = String.format("task %s", RandomText.randomString(2));

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("edge");
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
        Browser.maximize();
    }

    @Test
    void createNewTodo() {
        todoMVCPage.fill(taskName);

        Assert.assertEquals(todoMVCPage.getTodoName(), taskName);
    }

    @Test
    void markCompleteTodo() {
        todoMVCPage.fill(taskName);
        todoMVCPage.markAsCompleted();

        Assert.assertTrue(todoMVCPage.isCompleted());
    }

    @Test(groups = {"wip"})
    void verifyUserAbleDeleteATodo() {
        todoMVCPage.fill(taskName);

        todoMVCPage.deleteTodo();
        Assert.assertNotEquals(todoMVCPage.getTodoName(), taskName);
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
