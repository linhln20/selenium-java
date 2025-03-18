package internet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static supports.Browser.*;

public class JavaScriptErrorPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/javascript_error");
    }

    public boolean getConsoleErrors() {
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        boolean errorFound = false;

        for (LogEntry log : logs) {
            System.out.println("Log: " + log.getMessage());
            if (log.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")) {
                errorFound = true;
                break;
            }
        }
        return errorFound;
    }
}
