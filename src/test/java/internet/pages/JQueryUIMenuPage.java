package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

import static supports.Browser.*;

public class JQueryUIMenuPage {
    String downloadDir = System.getProperty("user.home") + "/Downloads";
    File downloadedFile;
    String fileName;

    public void open() {
        visit("https://the-internet.herokuapp.com/jqueryui/menu");
    }

    public void clickDisabled() {
        clickText("Disabled");
    }

    public String getUrl() {
        return getCurrentUrl();
    }

    public void clickEnabled() {
        clickText("Enabled");
    }

    public void clickDownloads(){
        clickText("Downloads");
    }

    public void clickPDFText() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        WebElement downloads = getElement(By.linkText("Downloads"));
        actions.moveToElement(downloads).perform();
        By pdfLocator = By.linkText("PDF");

        wait.until(ExpectedConditions.visibilityOfElementLocated(pdfLocator));
        WebElement pdfElement = getElement(pdfLocator);
        String pdfLink = pdfElement.getAttribute("href");
        fileName = pdfLink.substring(pdfLink.lastIndexOf("/") + 1);

        actions.moveToElement(pdfElement).click().perform();
        downloadedFile = new File(downloadDir, fileName);
    }

    public boolean isFileDownloaded() throws InterruptedException {
        int waitTime = 10;
        while (waitTime > 0 && !downloadedFile.exists()) {
            Thread.sleep(1000);
            waitTime--;
        }
        return downloadedFile.exists();
    }
    public void clickBackTo() {
        clickText("Back to JQuery UI");
    }

    public String getContentJQueryUI() {
        return getText(By.xpath("//*[@id='content']/div/div/p"));
    }
}
