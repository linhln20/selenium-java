package internet.pages;

import org.openqa.selenium.By;
import static supports.Browser.*;

public class BrokenImagesPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/broken_images");
    }
    public boolean isImagesBroken(By locator){
        return isBroken(locator);
    }
    public static boolean isBroken(By locator){
        int[] dimensions = getImageProperty(locator);
        if (dimensions[0] == 0 && dimensions[1] == 0) {
            System.out.println("Image is broken");
        } else {
            System.out.println("Image is loaded");
        }
        return dimensions[0] > 0 && dimensions[1] > 0;
    }
}