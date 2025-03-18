package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static supports.Browser.*;

public class DisappearingElementsPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/disappearing_elements");
    }

    public int galleryCount(){
        int iterations = 10;
        int galleryPresentCount = 0;
        for (int i = 0; i < iterations; i++) {
            visit("https://the-internet.herokuapp.com/disappearing_elements");
            List<WebElement> galleries = getDriver().findElements(By.linkText("Gallery"));
            if (!galleries.isEmpty() && galleries.get(0).isDisplayed()) {
                galleryPresentCount++;
            }
        }
        return galleryPresentCount;
    }
}
