package internet;

import internet.pages.TodoMVCPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class TodoMVCTest {
    TodoMVCPage todoMVCPage;
    String taskName = String.format("task %s", RandomText.randomString(1));

    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
    }

    @Test
    void createNewTodo() {
        todoMVCPage.fill(taskName);

        Assert.assertEquals(todoMVCPage.getTodoName(taskName), taskName);
        Assert.assertTrue(todoMVCPage.isTaskExit(taskName));
    }

    @Test
    void markCompleteTodo() {
        todoMVCPage.fill(taskName);
        todoMVCPage.markAsCompleted();

        Assert.assertTrue(todoMVCPage.isCompleted());
    }

    @Test
    void verifyUserAbleDeleteATodo() {
        todoMVCPage.fill(taskName);

        todoMVCPage.deleteTodo();
        Assert.assertFalse(todoMVCPage.isTaskExit(taskName));
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
