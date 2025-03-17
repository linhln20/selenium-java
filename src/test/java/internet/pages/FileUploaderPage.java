package internet.pages;

import org.openqa.selenium.*;
import supports.Browser;

import java.io.File;
import java.time.Duration;

import static supports.Browser.*;

public class FileUploaderPage {
    String filePath = new File(System.getProperty("user.dir") + "/src/test/resources/test-file.txt").getAbsolutePath();

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
        WebElement uploadInput = getElement(By.xpath("//*[@id='drag-drop-upload']"));
        executeScript(uploadInput, "arguments[0].style.display = 'block';");
        uploadInput.sendKeys(filePath);
    }

    public void uploadByDragAndDrop() {
        WebElement dropZone = getElement(By.id("drag-drop-upload"));
        executeScript(dropZone, "arguments[0].style.display = 'block';");
        dropZone.sendKeys(filePath);
    }

    public boolean verifyUpload() {
        return getElement(By.id("uploaded-files")).getText().contains("test-file.txt");
    }
}
