package todomvc;

import org.testng.annotations.Parameters;
import todomvc.page.TodoMVCPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

import static supports.Browser.openBrowser;

public class TodoMVCTest {
    TodoMVCPage todoMVCPage;
    String taskName = String.format("task %s", RandomText.randomString(1));

    @Parameters({"browser"})
    @BeforeMethod
    void setUp(String browser){
        openBrowser(browser);
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
    }

    @Test
    void createNewTodo() {
        int taskSizeBefore= todoMVCPage.getSize();
        todoMVCPage.fill(taskName);

        int currentTaskSize= todoMVCPage.getSize();
        Assert.assertEquals(currentTaskSize-taskSizeBefore,1);
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
        int taskSizeBefore= todoMVCPage.getSize();

        todoMVCPage.deleteTodoByName();
        int currentTaskSize= todoMVCPage.getSize();
        Assert.assertFalse(todoMVCPage.isTaskExit(taskName));
        Assert.assertEquals(taskSizeBefore-currentTaskSize,1);
    }

    @AfterMethod
    void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            Browser.captureScreen(testResult.getName());
        }
        Browser.quit();
    }
}
