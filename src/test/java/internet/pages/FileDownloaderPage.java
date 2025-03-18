package internet.pages;

import supports.Browser;

import java.io.File;
import java.nio.file.Paths;

import static supports.Browser.visit;

public class FileDownloaderPage {
    String fileName = "MiArchivo.pdf";
    String downloadPath = System.getProperty("user.home") + "/Downloads";

    public void open() {
        visit("https://the-internet.herokuapp.com/download");
    }

    public void clickDownloadFile() {
        Browser.clickText(fileName);
    }

    public void isFileDownload() throws InterruptedException {
        File downloadedFile = Paths.get(downloadPath, fileName).toFile();
        int waitTime = 10;
        while (waitTime > 0) {
            if (downloadedFile.exists()) {
                System.out.println("Successfully downloaded: " + downloadedFile.getAbsolutePath());
                break;
            }
            Thread.sleep(1000);
            waitTime--;
        }
        if (!downloadedFile.exists()) {
            System.out.println("Download failed");
        }
    }
}
