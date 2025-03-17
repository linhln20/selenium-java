package internet.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import java.nio.file.Paths;
import java.time.Duration;

import static supports.Browser.*;

public class FileUploaderPage {
    String filePath = "C:\\Users\\lamng\\Desktop\\test-file.docx";

    public void open(){
        visit("https://the-internet.herokuapp.com/upload");
        Browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void uploadUsingChooseFile() {
        WebElement uploadInput = getElement(By.id("file-upload"));
        uploadInput.sendKeys(filePath);
        clickBtn(By.id("file-submit"));
    }

    public void uploadByClickDragDrop() {
        getElement(By.cssSelector("#drag-drop-upload")).click();
        WebElement uploadInput = getElement(By.xpath("//*[@id='drag-drop-upload']"));

        uploadInput.sendKeys(filePath);
        Actions actions = new Actions(Browser.getDriver());
        actions.keyDown(Keys.ENTER).perform();
    }

    public void uploadByDragAndDrop() {
        WebElement dropZone = getElement(By.id("drag-drop-upload"));

        Actions actions = new Actions(Browser.getDriver());
        actions.dragAndDrop((WebElement) Paths.get(filePath).toFile(), dropZone).perform();
    }

    public boolean verifyUpload() {
        return getElement(By.id("uploaded-files")).getText().contains("test-file.docx");
    }
}
