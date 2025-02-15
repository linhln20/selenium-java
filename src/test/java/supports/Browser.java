package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBrowser(String browser){
        switch (browser.toLowerCase()){
            case "chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox":{
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public static void initializeWait(int timeout){
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//        driver.findElement(locator).click();
    }
    public static void clickBtn(By locator){
        driver.findElement(locator).click();
    }

    public static void clickText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public static void swithToFrame(String name){
        driver.switchTo().frame(name);
    }

    public static void swithParentFrame(){
        driver.switchTo().parentFrame();
    }
    public static void swithDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public static void back(){
        driver.navigate().back();}

    public static void select(By locator){
        driver.findElement(locator).click();
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void fill(By locator, CharSequence... withText){
        driver.findElement(locator).sendKeys(withText);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static int[] getImageProperty(By locator){
        int[] dimensions = new int[2];
        driver.findElements(locator).forEach(img -> {
            dimensions[0] = Integer.parseInt(img.getDomProperty("naturalHeight"));
            dimensions[1] = Integer.parseInt(img.getDomProperty("naturalWidth"));
        });
        return dimensions;
    }

    public static void captureScreen(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void sentKey(String key){
        driver.switchTo().alert().sendKeys(key);
    }
    public static void sentText(By locator, String text){
    driver.findElement(locator).sendKeys(text);
    }


    public static void quit(){
        driver.quit();
    }
}
